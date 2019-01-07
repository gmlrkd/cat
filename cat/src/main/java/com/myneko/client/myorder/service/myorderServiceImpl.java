package com.myneko.client.myorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myneko.client.md.vo.MdVO;
import com.myneko.client.member.vo.MemberVO;
import com.myneko.client.myorder.dao.myorderDao;
import com.myneko.client.myorder.vo.myorderVO;

@Service
@Transactional
public class myorderServiceImpl implements myorderService {

	@Autowired
	private myorderDao myorderDao;

	// 나의주문내역 리스트 목록
		public List<myorderVO> myorderList(myorderVO mvo) {
			List<myorderVO> myList = null;

			myList = myorderDao.myorderList(mvo);
			return myList;
		}

		
		  @Override public myorderVO myorderDetail(myorderVO mvo) { myorderVO detail =
		  null; detail = myorderDao.myorderDetail(mvo); return detail; }
		 

		@Override
		public List<MdVO> findProduct(int o_number) {
			List<MdVO> myList = null;

			myList = myorderDao.findProduct(o_number);
			return myList;
		}

		@Override
		public MemberVO findMember(int o_number) {
			MemberVO detail = null;
			detail = myorderDao.findMember(o_number);
			return detail;
		}

		@Override
		public myorderVO findOrder(int o_number) {
			myorderVO detail = null;
			detail = myorderDao.findOrder(o_number);
			return detail;
		}

		@Override
		public int myorderDelete(int o_number) {
			int result = 0;
			try {
				result = myorderDao.myorderDelete(o_number);
			} catch (Exception e) {
				e.printStackTrace();
				result = 0;
			}
			return result;
		}


		@Override
		public int myorderListCnt(myorderVO mvo) {
			return myorderDao.myorderListCnt(mvo);
		}


	@Override
	public int myorderAddressModify(myorderVO mvo) {
		
		return myorderDao.myorderAddressModify(mvo);
	}

}
