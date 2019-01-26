package auxiliary.plugins.mybatis.redisCache;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.Properties;

@Intercepts({@Signature(type = StatementHandler.class, method="prepare", args = {Connection.class, Integer.class})})
public class RedisCacheInterceptor implements Interceptor {

    private static Logger logger = LoggerFactory.getLogger(RedisCacheInterceptor.class);

    public Object intercept(Invocation invocation) throws Throwable {

        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();


        System.out.println("你好1-----------------------------------------------------------------");
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties var1) {
        System.out.println("你好2-----------------------------------------------------------------");
    }

}
