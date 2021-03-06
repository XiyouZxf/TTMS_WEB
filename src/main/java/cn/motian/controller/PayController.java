package cn.motian.controller;

import cn.motian.constant.TTMSConst;
import cn.motian.serveice.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static cn.motian.constant.TTMSConst.TTMS_RESULT_STATUS.FAIL;
import static cn.motian.constant.TTMSConst.TTMS_RESULT_STATUS.SUCCEED;

@Controller
@RequestMapping(TTMSConst.TTMS_SERVER_URL.CONDUCTOR)
public class PayController {
    @Autowired
    private PayService payService;


    @RequestMapping(params = "method=pay", method = RequestMethod.POST)
    @ResponseBody
    // 传入票的ID列表 以,分隔
    public Map<String, Object> Pay(
            @RequestParam String userId,   //用户id
            @RequestParam String ticketList,  //购票列表
            @RequestParam String paymentAmount //支付金额
    ) {

        Map<String, Object> rs = new HashMap<>();
        rs.put("result", payService.pay(userId, ticketList, paymentAmount) ? SUCCEED : FAIL);
        return rs;
    }


}