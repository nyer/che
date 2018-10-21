package com.che.dao.impl;

import com.che.dao.AccountDao;
import com.che.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDaoImpl  implements AccountDao {

    @Override
    public int insert(Account record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Account record) {
        return 0;
    }

    @Override
    public Account getByAccountId(String accountId, Integer accountType) {
        return null;
    }
}
