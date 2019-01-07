package com.myneko.client.cart.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.myneko.client.cart.service.CartService;
import com.myneko.client.cart.vo.CartVO;
import com.myneko.client.cart.vo.CatorderVO;
import com.myneko.client.cart.vo.PartiorderVO;

import lombok.extern.java.Log;

@RestController
@RequestMapping(value = "/cart")
@Log
public class CartController {

	@Autowired
	CartService cartService;

	// 장바구니 목록
		@RequestMapping(value = "/cartList", method = RequestMethod.GET)
		public ModelAndView cartList(@ModelAttribute CartVO ctvo, Model model) {
		
			log.info("장!바!구!니!호!출!성!공");
			
			ModelAndView mav = new ModelAndView();
			List<CartVO> cartList = cartService.cartList(ctvo);
			model.addAttribute("cartList", cartList);
			model.addAttribute("data", ctvo);
			mav.setViewName("cart/cartList");

			return mav;
		}
	
		// 장바구니 상품 삭제
		@RequestMapping(value="/{ct_number}.do" , method = RequestMethod.DELETE)
		public ResponseEntity<String> cartDelete(@PathVariable("ct_number") Integer ct_number) {
			log.info("cartDelete 호출 성공!");
			ResponseEntity<String> entity = null;
			try {
				cartService.cartDelete(ct_number);
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			return entity;
		}
	
		// 장바구니 수량 수정
		@RequestMapping(value ="/{ct_number}.do", method = {RequestMethod.PUT, RequestMethod.PATCH})
		public ResponseEntity<String> cartUpdate(@PathVariable("ct_number") Integer ct_number, @RequestBody CartVO ctvo) {
			log.info("cartUpdate 호출 성공!");
			ResponseEntity<String> entity = null;
			try {
				ctvo.setCt_number(ct_number);
				cartService.cartUpdate(ctvo);
				
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			return entity;
		}
	
	// 장바구니 insert
	@ResponseBody
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String cartInsert(@RequestBody CartVO ctvo, HttpServletRequest request, Model model) throws Exception {
		String result="";
		int r;
			
		log.info("--- cartInsert 호출되었습니다 ---");
		
		System.out.println("ctvo m_number : " + ctvo.getM_number());
		System.out.println("ctvo p_number : " + ctvo.getP_number());
		System.out.println("ctvp ct_amount : " + ctvo.getCt_amount());
		
		r = cartService.checkcart(ctvo);
			
		if(r==0) {
			r = cartService.cartInsert(ctvo);
			if(r==1) {
				result = "SUCCESS";
			} else {
				result = "FAIL";
			}
		} else {
			result = "FAIL";
		}
			
		return result;
	}
	
	// 장바구니에서 결제페이지
	@RequestMapping(value = "/payment", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView payment(Model model, @RequestParam("m_number") int m_number) {
		log.info("--- 결제페이지 호출했습니다 ---");

		CartVO ctvo = new CartVO();
		ModelAndView mav = new ModelAndView();

		ctvo.setM_number(m_number);

		List<CartVO> cartList = cartService.cartList(ctvo);
		model.addAttribute("cartList", cartList);

		mav.setViewName("cart/payment");

		return mav;
	}

	// mddetail에서 결제페이지
	@RequestMapping(value = "/onePayment", method = RequestMethod.GET)
	public ModelAndView onePayment(@ModelAttribute CartVO ctvo, ModelAndView mav, HttpServletRequest request) {

		log.info("--- ONE 결제페이지 호출했습니다 ---");

		HttpSession session = request.getSession(true);
		
		System.out.println(ctvo.getP_name());
		
		session.setAttribute("rnp_pnumber", ctvo.getP_number());
		session.setAttribute("rnp_pname", ctvo.getP_name());
		session.setAttribute("rnp_pprice", ctvo.getP_price());
		session.setAttribute("rnp_pcount", ctvo.getCt_amount());
		
		mav.setViewName("/cart/paymentOne");
		
		return mav;
	}
	
	// mddetail -> payment -> insert
	@ResponseBody
	@RequestMapping(value="/orderinsertOne", method = { RequestMethod.GET,RequestMethod.POST})
	public String orderinsertone(@RequestBody CatorderVO covo, HttpSession session, Model model) {
		log.info("--- cat order insert ONE ---");
		String result = "";
		int success = 0;
		
		PartiorderVO ptvo = new PartiorderVO();
		
		int o_number = cartService.onumber();
		System.out.println("--- order_number : " + o_number + " ---");
		
		if(o_number==0) {
			result="FAIL";
			return result;
		} else {
			covo.setO_number(o_number);
			success = cartService.orderinsertOne(covo);
			if(success==1) {
				ptvo.setO_number(o_number);
				ptvo.setP_number(Integer.parseInt(session.getAttribute("rnp_pnumber").toString()));
				ptvo.setPo_amount(Integer.parseInt(session.getAttribute("rnp_pcount").toString()));
				ptvo.setPo_price(Integer.parseInt(session.getAttribute("rnp_pprice").toString()));
				
				success = cartService.orderinsertOneP(ptvo);
				if(success==1) {
					result = "SUCCESS";
					session.removeAttribute("rnp_pnumber");
					session.removeAttribute("rnp_pcount");
					session.removeAttribute("rnp_pprice");
				} else {
					result = "FAIL";
				}
			}
		}
		
		if(covo.getU_milage()!=0) {
			int rs = cartService.usemilage(covo);
		}
		
		return result;
	}
	
	// cart -> payment -> insert
	@ResponseBody
	@RequestMapping(value="/orderinsertAll", method = { RequestMethod.GET,RequestMethod.POST})
	public String orderinsertall(@RequestBody CatorderVO covo, HttpSession session, Model model) {
		log.info("--- cat order insert CART ALL ---");
		String result = "";
		int success = 0;
		
		PartiorderVO ptvo = null;
		
		int o_number = cartService.onumber();
		System.out.println("--- order_number : " + o_number + " ---");
		
		if(o_number==0) {
			result="FAIL";
			return result;
		} else {
			covo.setO_number(o_number);
			success = cartService.orderinsertAll(covo);
			if(success==1) {
				CartVO ctvo = new CartVO();
				ctvo.setM_number((Integer)session.getAttribute("m_number"));
				List<CartVO> list = cartService.cartList(ctvo);
				
				for(int i=0 ; i<list.size() ; i++) {
					ptvo = new PartiorderVO();
					ptvo.setO_number(o_number);
					ptvo.setP_number(list.get(i).getP_number());
					ptvo.setPo_amount(list.get(i).getCt_amount());
					ptvo.setPo_price(list.get(i).getP_price());
					
					success = cartService.orderinsertAllP(ptvo);
				}
			}
		}
		
		if(success==1) {
			result = "SUCCESS";
			
			cartService.deleteAll((Integer)session.getAttribute("m_number"));
		} else {
			result = "FAIL";
		}
		
		if(covo.getU_milage()!=0) {
			int rs = cartService.usemilage(covo);
		}
		
		return result;
	}
	
}






































