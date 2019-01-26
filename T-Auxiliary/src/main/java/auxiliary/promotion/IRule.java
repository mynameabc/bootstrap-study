package auxiliary.promotion;

import communal.Result;

public interface IRule {

    /**
     * 检查规则
     * @return
     */
    public Result CheckRule(long orderId);

    /**
     * 检查并执行规则
     * @return
     */
    public Result CheckAndImplementRule(long orderId);
}
