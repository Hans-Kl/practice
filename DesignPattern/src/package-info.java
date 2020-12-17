/**
 * 单例模式
 * 作用:保证JVM范围内一个类只有一个实例,并提供一个访问该实例的全局访问点
 * 实现步骤:
 * 1. 私有化构造方法,防止外部使用new关键字
 * 2. 新建静态变量缓存唯一实例
 * 3. 对外暴露一个静态方法,返回唯一实例
 * <p>2020/12/3 14:19</p>
 *
 * @author konglinghan
 * @version 1.0
 */