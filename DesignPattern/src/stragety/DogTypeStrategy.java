package stragety;

/**
 * <p>2021/1/23 14:59</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class DogTypeStrategy implements TypeStartegy{
    @Override
    public String buildType() {
        System.out.println("获得狗狗类型type");
        return "dog";
    }
}
