package stragety;

/**
 * <p>2021/1/23 14:59</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class CatTypeStrategy implements TypeStartegy{
    @Override
    public String buildType() {
        System.out.println("获得猫咪类型type");
        return "cat";
    }
}
