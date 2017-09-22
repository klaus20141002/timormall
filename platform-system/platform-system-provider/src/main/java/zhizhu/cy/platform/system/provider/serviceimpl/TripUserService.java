package zhizhu.cy.platform.system.provider.serviceimpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhizhu.cy.platform.common.service.service.CrudService;
import zhizhu.cy.platform.system.api.entity.TripUser;
import zhizhu.cy.platform.system.api.service.ITripUserService;
import zhizhu.cy.platform.system.provider.mapper.TripUserMapper;

/**
 * 用户服务实现
 *
 * @author zhangxd
 */
@Service
@Transactional(readOnly = true)
public class TripUserService extends CrudService<TripUserMapper, TripUser> implements ITripUserService {

    @Override
    public TripUser getByMobile(String mobile) {
        return getDao().getByMobile(mobile);
    }
    
    
    @Override
    public TripUser getByOpenId(String open_id) {
        return getDao().getByOpenId(open_id);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateInfo(TripUser tripUser) {
        tripUser.preUpdate();
        getDao().updateInfo(tripUser);
    }

    @Override
    @Transactional(readOnly = false)
    public void registryUser(String mobile, String password) {
        // 用户已存在不做处理，防止客户端重复提交
        TripUser oldUser = getByMobile(mobile);
        if (oldUser != null) {
            return;
        }

        //插入用户信息
        TripUser user = new TripUser();
        user.preInsert();
        user.setMobile(mobile);
        user.setPassword(password);
        getDao().insert(user);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void registryUserByWechat(TripUser user) {
        // 用户已存在不做处理，防止客户端重复提交
        TripUser oldUser = getByMobile(user.getUserId());
        if (oldUser != null) {
            return;
        }

        //插入用户信息
        getDao().insert(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void updatePasswordByMobile(String mobile, String password) {
        getDao().updatePasswordByMobile(mobile, password);
    }

    @Override
    @Transactional(readOnly = false)
    public void updatePhotoByUserId(String userId, String photo) {
        getDao().updatePhotoByUser(userId, photo);
    }

}
