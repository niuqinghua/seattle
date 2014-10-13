package city.seattle.controller;

import city.seattle.exception.WebException;
import city.seattle.manager.SeattleService;
import city.seattle.pagination.PaginationQuery;
import city.seattle.pagination.PaginationResult;
import city.seattle.util.ResultVoUtils;
import city.seattle.util.UserUtils;
import city.seattle.vo.ResultVo;
import city.seattle.vo.SeattleVo;
import org.apache.shiro.authz.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by niuqinghua on 2014/9/16.
 */
@Controller
@RequestMapping("/seattle")
public class SeattleController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(SeattleController.class);

    @Autowired
    private SeattleService seattleService;

    @RequiresAuthentication
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResultVo create(SeattleVo seattleVo) {
        if(seattleVo == null) {
            return ResultVoUtils.createFailed("seattleVo不能为空");
        }

        try{
            seattleService.create(seattleVo);
            return ResultVoUtils.createSucess();
        } catch (Exception e) {
            logger.error("创建Seattle实例异常", e);
            return ResultVoUtils.createFailed("创建Seattle实例异常");
        }
    }

    @RequiresUser
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultVo update(SeattleVo seattleVo) {
        if(seattleVo == null) {
            return ResultVoUtils.createFailed("seattleVo不能为空");
        }

        try{
            seattleService.update(seattleVo);
            return ResultVoUtils.createSucess();
        } catch (Exception e) {
            logger.error("更新Seattle实例异常", e);
            return ResultVoUtils.createFailed("更新Seattle实例异常");
        }
    }

    @RequiresRoles(value={"admin", "user"}, logical= Logical.AND)
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView detail(@RequestParam long id) {
        try {
            SeattleVo seattleVo = seattleService.get(id);
            ModelMap model = new ModelMap();
            model.put("seattle", seattleVo);
            model.put("userId", UserUtils.getUserId());
            model.put("userName", UserUtils.getUserName());
            return new ModelAndView("/seattle/detail", model);
        } catch (Exception e) {
            logger.error("获取Seattle详情异常", e);
            throw new WebException("获取Seattle详情异常");
        }
    }

    @RequiresPermissions("permissions")
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public PaginationResult<SeattleVo> list(PaginationQuery query) {
        if(query == null) {
            logger.error("查询参数不能为空");
            throw new WebException("查询参数不能为空");
        }

        try{
            return seattleService.findSeattles(query);
        } catch (Exception e) {
            logger.error("获取Seattle列表异常", e);
            throw new WebException("获取Seattle列表异常");
        }
    }

}
