package module.test;

import java.util.List;

public interface ITest {

    /**
     * Redis锁
     */
    void redisLock();

    /**
     * Redis事务
     */
    void redisTransaction();

    List<Test> getDataList();
}
