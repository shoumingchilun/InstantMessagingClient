package util;

/**
 * @auther 齿轮
 * @create 2023-05-20-10:45
 */
public class RollBackImpl implements RollBack{
    @Override
    public void LoginSuccess() {
        System.out.println("success");
    }

    @Override
    public void LoginFailure() {
        System.out.println("Failure");
    }

    @Override
    public void getFriendsSuccess() {
//        Utils.friends.forEach(System.out::println);
    }

    @Override
    public void Receive(String name,String message){
        System.out.println(name+"："+message);
    }
}
