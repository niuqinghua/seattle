package city.seattle.util;

import city.seattle.vo.ResultVo;

/**
 * Created by niuqinghua on 2014/9/16.
 */
public class ResultVoUtils {

    public static ResultVo createSucess() {
        return create(true, null);
    }

    public static ResultVo createSucess(String message) {
        return create(true, message);
    }

    public static ResultVo createFailed(String message) {
        return create(true, message);
    }

    public static ResultVo create(boolean success, String message) {
        return new ResultVo(success, message);
    }
}
