package city.seattle.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import rome.footstone.shiro.User;

/**
 * Created by niuqinghua on 2014/9/14.
 */
public class UserUtils {

    public static String getUserId() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return user.getId();
    }

    public static String getUserName() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return user.getName();
    }

}
