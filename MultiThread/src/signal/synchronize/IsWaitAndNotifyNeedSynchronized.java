package signal.synchronize;

import org.omg.CORBA.Object;

/**
 * 测试wait()/notify()是否需要被包围在同步块中
 * 结论:需要,否则抛出IllegalMonitorStateException异常
 * <p>2020/9/16 10:28</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class IsWaitAndNotifyNeedSynchronized {
    public static void main(String[] args) throws InterruptedException {
       String s ="";
       s.wait();
    }
}
