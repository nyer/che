package com.che.dao;

import com.che.model.Account;

public interface AccountDao {

    int insert(Account record);

    Account getByAccountId(String accountId, Integer accountType);

    int updateByPrimaryKeySelective(Account record);
}