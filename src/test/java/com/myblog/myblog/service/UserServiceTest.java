//package com.myblog.myblog.service;
//
//import com.myblog.myblog.domain.User;
//import com.myblog.myblog.dto.ValidCheckDto;
//import com.myblog.myblog.repository.UserRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//class UserServiceTest {
//    @Mock
//    UserRepository userRepository;
//
//    @Test
//    @DisplayName("아이디 중복테스트 - 중복있음")
//    void updateProduct_Normal() {
//        // given
//        UserValidService userValidService = new UserValidService(userRepository);
//        User user = new User("yuri", "1234");
//        when(userRepository.save(user)).thenReturn(user);
//
//
//        //클라이언트로 부터 받는 Dto
//        ValidCheckDto validCheckDto = new validCheckDto(
//                "yuri", "1234", "1234"
//        );
//
//        //when
//        User user1 = userRepository.save(user);
//
//        //then
//        assertEquals(user1.getUsername(), requestDto.getUsername());
//    }
//
//    @Test
//    @DisplayName("관심 상품 희망가 - 최저가 미만으로 변경")
//    void updateProduct_Failed() {
//        // given
//        Long productId = 100L;
//        int myprice = MIN_MY_PRICE - 50;
//
//        ProductMypriceRequestDto requestMyPriceDto = new ProductMypriceRequestDto(
//                myprice
//        );
//
//        ProductService productService = new ProductService(productRepository);
//
//        // when
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            productService.updateProduct(productId, requestMyPriceDto);
//        });
//
//        // then
//        assertEquals(
//                "유효하지 않은 관심 가격입니다. 최소 " + MIN_MY_PRICE + " 원 이상으로 설정해 주세요.",
//                exception.getMessage()
//        );
//    }
//}
//}