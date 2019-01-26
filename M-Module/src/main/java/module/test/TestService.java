package module.test;

import auxiliary.redis.RedisUtil;
import communal.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
import redis.clients.util.Pool;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService implements ITest {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private Pool<Jedis> jedisPool;

    @Autowired
    private RedisUtil redisUtil;

    public void redisLock() {

        Result result = null;

        Jedis jedis = jedisPool.getResource();

        jedis.set("a", "1");
        jedis.watch("a");

        {
            logger.info("redis锁!");
        }

    }

    public void redisTransaction() {

        redisUtil.set("memberId", "你好!");
        System.out.println(redisUtil.get("memberId"));

        Jedis jedis = jedisPool.getResource();


        Transaction transaction = jedis.multi();

        {
            logger.info("redis事务!");
        }

        transaction.exec();
    }

    public List<Test> getDataList() {

        System.out.println("0123");

        logger.info("1234");

        List<Test> list = new ArrayList<>();

        Test t1 = new Test();
        t1.setCode("001");
        t1.setName("这是t1");
        t1.setCalcMode(1);
        list.add(t1);

        Test t2 = new Test();
        t2.setCode("002");
        t2.setName("这是t2");
        t2.setCalcMode(2);
        list.add(t2);

        Test t3 = new Test();
        t3.setCode("003");
        t3.setName("这是t3");
        t3.setCalcMode(3);
        list.add(t3);

        Test t4 = new Test();
        t4.setCode("004");
        t4.setName("这是t4");
        t4.setCalcMode(4);
        list.add(t4);

        Test t5 = new Test();
        t5.setCode("005");
        t5.setName("这是t5");
        t5.setCalcMode(5);
        list.add(t5);

        return list;
    }
}
