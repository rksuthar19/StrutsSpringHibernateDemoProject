package com.suthar.rentel.ui.action;

import com.opensymphony.xwork2.ActionSupport;
import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.model.Transaction;
import com.suthar.rentel.domain.repository.TransactionRepository;
import com.suthar.rentel.ui.interceptor.CustomerAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Scope(value = "prototype")
@Component
public class ViewHistoryAction extends ActionSupport implements CustomerAware {

    @Autowired
    private TransactionRepository transactionRepository;

    private Collection<Transaction> transactions;
    private Customer customer;

    @Override
    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public Collection<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String execute() throws Exception {
        transactions = transactionRepository.transactionsBy(customer);
        return SUCCESS;
    }
}
