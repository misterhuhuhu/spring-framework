package aspectj.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * aspect :跨多个对象的关注点的模块化。每个方面都侧重于特定的横切功能
 * Join point: 脚本执行过程中的点，例如方法或属性访问的执行。
 * Advice: 某个方面在特定连接点采取的操作
 * Pointcut: 匹配连接点的正则表达式。通知与切入点表达式关联，并在与切入点匹配的任何连接点运行
 */
public aspect AccountAspect {
    private static final Logger logger = LoggerFactory.getLogger(AccountAspect.class);
    final int MIN_BALANCE = 10;

    pointcut callWithDraw(int amount, Account account):
             call(boolean aspectj.account.Account.withdraw(int)) && args(amount) && target(account);

    before(int amount, Account account) : callWithDraw(amount, account) {
        logger.info(" Balance before withdrawal: {}", account.balance);
        logger.info(" Withdraw ammout: {}", amount);
    }

    boolean around(int amount, Account account) : callWithDraw(amount, account) {
        if (account.balance < amount) {
            logger.info("Withdrawal Rejected!");
            return false;
        }
        return proceed(amount, account);
    }

    after(int amount, Account balance) : callWithDraw(amount, balance) {
        logger.info("Balance after withdrawal : {}", balance.balance);
    }
}
