package com.klauting.timormall.system.provider.serviceimpl;

import com.klauting.timormall.common.utils.RandomHelper;
import com.klauting.timormall.system.api.entity.TripUser;
import com.klauting.timormall.system.api.exception.InvalidCaptchaException;
import com.klauting.timormall.system.api.exception.UserExistException;
import com.klauting.timormall.system.api.exception.UserNotExistException;
import com.klauting.timormall.system.api.exception.base.BusinessException;
import com.klauting.timormall.system.api.service.ICaptchaService;
import com.klauting.timormall.system.api.service.ITripUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.klauting.timormall.common.redis.RedisRepository;

/**
 * 验证码服务
 *
 * @author zhangxd
 */
@Service
@Transactional(readOnly = true)
public class CaptchaService implements ICaptchaService {

    /**
     * 用户服务
     */
    @Autowired
    private ITripUserService tripUserService;
    /**
     * redis repository
     */
    @Autowired
    private RedisRepository redisRepository;
    /**
     * 缓存前缀
     */
    private static final String REDIS_PREFIX = "captcha_";

    @Override
    public void sendCaptcha4Registry(String mobile) throws BusinessException {
        TripUser user = tripUserService.getByMobile(mobile);
        // 注册,如果用户存在
        if (user != null) {
            throw new UserExistException(String.format("手机号 '%s' 已经注册,直接登录", mobile));
        }

        sendCaptcha(mobile);
    }

    @Override
    public void sendCaptcha4Forget(String mobile) throws BusinessException {
        TripUser user = tripUserService.getByMobile(mobile);
        // 忘记密码,如果用户不存在
        if (user == null) {
            throw new UserNotExistException(String.format(" 手机号 '%s' 未注册", mobile));
        }

        sendCaptcha(mobile);
    }

    @Override
    public void validCaptcha(String mobile, String captcha) throws InvalidCaptchaException {
        String code = redisRepository.get(REDIS_PREFIX + mobile);
        if (!captcha.equals(code)) {
            throw new InvalidCaptchaException(String.format("验证码 '%s' 无效", captcha));
        }
    }

    /**
     * 发送验证码
     *
     * @param mobile 手机号
     * @throws BusinessException the business exception
     */
    private void sendCaptcha(String mobile) throws BusinessException {
        String code = RandomHelper.getRandNum(6); //验证码
        long time = 15L; //15分钟有效期

        //存入 Redis
        redisRepository.setExpire(REDIS_PREFIX + mobile, code, time * 60); //15分钟有效期

        System.out.printf("向 %s 发送短信验证码\n", mobile);
        System.out.printf("您的验证码为：%s，有效期：%s 分钟\n", code, time);
    }
}
