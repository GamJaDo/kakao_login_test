package kakaologin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kakaologin.service.KakaoService;

@Controller
public class KakaoController {

    @Autowired
    private KakaoService kakaoService;

    @GetMapping("/oauth/kakao/callback")
    public String kakaoCallback(@RequestParam("code") String code, Model model) {
        String accessToken = kakaoService.getAccessToken(code);
        // 액세스 토큰을 콘솔에 출력
        System.out.println("Access Token: " + accessToken);
        // 액세스 토큰을 모델에 추가하여 뷰에 전달
        model.addAttribute("accessToken", accessToken);
        return "accessToken"; // 액세스 토큰을 표시할 뷰 이름
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
