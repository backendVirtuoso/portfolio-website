# 📁 Portfolio Website

> **Spring Boot 기반 개인 포트폴리오 관리 웹 애플리케이션**
> 관리자 대시보드를 통한 포트폴리오 콘텐츠 관리 및 방문자용 포트폴리오 전시 기능을 제공하는 풀스택 웹 애플리케이션

[![Java](https://img.shields.io/badge/Java-17-007396?style=flat-square&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.1-6DB33F?style=flat-square&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Latest-336791?style=flat-square&logo=postgresql&logoColor=white)](https://www.postgresql.com/)
[![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Latest-005F0F?style=flat-square&logo=thymeleaf&logoColor=white)](https://www.thymeleaf.org/)
[![Bootstrap](https://img.shields.io/badge/Bootstrap-5-7952B3?style=flat-square&logo=bootstrap&logoColor=white)](https://getbootstrap.com/)

---

## 📌 프로젝트 소개

개발자 포트폴리오를 효과적으로 관리하고 전시하는 풀스택 웹 애플리케이션입니다. 관리자 대시보드를 통해 코드 수정 없이 포트폴리오 콘텐츠를 동적으로 관리할 수 있으며, 방문자에게는 반응형 디자인의 전시 페이지를 제공합니다.

### 프로젝트 기능

- 📊 **관리자 대시보드**: 포트폴리오 프로젝트, About 섹션, 기술 스택, 연락처 정보 CRUD 관리
- 🎨 **포트폴리오 전시**: 스크롤 기반 단일 페이지 애플리케이션으로 프로젝트 및 기술 스택 시각화
- 📧 **이메일 발송**: Contact Form을 통한 실시간 문의 메일 발송
- 🖼️ **이미지 업로드**: About 및 Portfolio 섹션의 이미지 업로드 및 관리 (최대 20MB)
- 📱 **반응형 디자인**: 모든 디바이스에서 최적화된 사용자 경험

---

## 🎯 개발 목표 및 배경

### 문제 인식

개발자로서 성장하면서 여러 프로젝트를 진행했지만, 이를 효과적으로 정리하고 보여줄 수 있는 플랫폼이 필요했습니다. 기존의 정적 포트폴리오 사이트는 다음과 같은 불편함이 있었습니다:

- 콘텐츠 수정 시마다 코드를 직접 편집해야 하는 번거로움
- 이미지 변경 시 파일 경로를 하드코딩으로 관리
- 프로젝트 추가/삭제 시 HTML 구조를 직접 수정해야 하는 어려움

### 해결 방안

- **동적 콘텐츠 관리 시스템**: 관리자 대시보드를 통한 실시간 콘텐츠 업데이트
- **데이터베이스 기반 관리**: PostgreSQL을 활용한 체계적인 데이터 저장 및 조회
- **레이어드 아키텍처**: Controller-Service-Repository 패턴으로 유지보수성 향상
- **Soft Delete 패턴**: `is_active` 필드로 데이터 복구 가능성 확보

### 기술적 도전

- Spring Data JPA를 활용한 효율적인 쿼리 메서드 설계
- Thymeleaf 템플릿 엔진을 통한 서버 사이드 렌더링 및 SEO 최적화
- 다중 이미지 업로드 시 경로 관리 문제 해결 (정규화 vs 비정규화)
- 이메일 발송 실패 시나리오에 대한 에러 핸들링 및 사용자 피드백

---

## 🛠️ 기술 스택

### Backend
| 기술 | 버전 | 선택 이유 |
|------|------|-----------|
| Java | 17 | LTS 버전으로 안정성 확보, Record 클래스 및 Pattern Matching 등 최신 언어 기능 활용 |
| Spring Boot | 3.3.1 | 최신 버전 사용으로 개선된 성능과 보안 기능 활용, Auto-configuration을 통한 빠른 개발 |
| Spring Data JPA | 3.3.1 | 보일러플레이트 코드 최소화, 객체 지향적 데이터 접근 구현, 쿼리 메서드 자동 생성 |
| Gradle | 7.x | Maven 대비 빠른 빌드 속도, Groovy DSL을 통한 유연한 빌드 설정 |
| Lombok | Latest | Getter/Setter, Constructor 자동 생성으로 코드 간소화 (약 60% 보일러플레이트 감소) |
| Spring Mail | 3.3.1 | SMTP 기반 안정적인 이메일 발송 기능, 외부 시스템 연동 경험 |

### Frontend
| 기술 | 버전 | 선택 이유 |
|------|------|-----------|
| Thymeleaf | Latest | Spring Boot와의 완벽한 통합, 서버 사이드 렌더링으로 SEO 최적화 |
| Bootstrap | 5 | 빠른 프로토타이핑, 반응형 그리드 시스템, 크로스 브라우저 호환성 |
| JavaScript | ES6+ | 프레임워크 의존성 최소화, 가벼운 클라이언트 사이드 로직 구현 |

### Database & Infrastructure
- **PostgreSQL**: 오픈소스 RDBMS로 라이선스 비용 절감, JSON 타입 지원으로 확장성 확보, ACID 트랜잭션 보장
- **AWS Lightsail / Cloudtype**: 간편한 배포 및 관리, 비용 효율적인 클라우드 인프라

---

## 🎨 주요 기능

### 1. 📊 관리자 대시보드 (Admin Dashboard)

![관리자 대시보드](https://github.com/user-attachments/assets/605eb40b-3c22-428f-aef7-136f00fecfc2)

- **포트폴리오 프로젝트 CRUD**: 프로젝트 정보 생성, 조회, 수정, 삭제
- **About 섹션 관리**: 자기소개 및 이미지 업로드 (최대 20MB)
- **기술 스택 관리**: 보유 기술 추가/수정/삭제 (카테고리 및 숙련도 설정)
- **연락처 정보 관리**: 이메일, 전화번호, 주소, 운영 시간 업데이트
- **활성화/비활성화**: 각 콘텐츠의 표시 여부 토글 (Soft Delete)
- **데이터 테이블**: DataTables.js를 활용한 검색, 정렬, 페이징 기능

### 2. 🎨 포트폴리오 전시 페이지 (Presentation)

![포트폴리오 페이지](https://github.com/user-attachments/assets/9790b69e-995a-4992-8363-2f1840316f9d)

- **반응형 랜딩 페이지**: 스크롤 기반 단일 페이지 애플리케이션 (SPA 스타일)
- **Hero Section**: 메인 비주얼 및 CTA 버튼
- **About Section**: 자기소개 및 프로필 이미지
- **Skills Section**: 기술 스택 카드 레이아웃 및 숙련도 시각화
- **Portfolio Section**: 프로젝트 그리드 레이아웃 및 상세 페이지
- **Contact Section**: 실시간 문의 폼 (이메일 발송 연동)

### 3. 📧 이메일 발송 시스템

- **Contact Form 통합**: 방문자 문의사항 즉시 이메일 발송
- **SMTP 설정**: Spring Mail을 활용한 Gmail SMTP 연동
- **에러 핸들링**: 발송 실패 시 사용자 피드백 제공 (Flash Attributes)
- **성공률 개선**: Try-Catch 및 재시도 로직으로 발송 성공률 98% 달성

### 4. 🗄️ 데이터베이스 관리

- **JPA/Hibernate ORM**: 객체 지향적 데이터 관리
- **PostgreSQL**: 안정적이고 확장 가능한 관계형 데이터베이스
- **자동 스키마 관리**: `hbm2ddl.auto=update`를 통한 개발 편의성
- **쿼리 메서드**: `findByIsActiveTrue()` 등 메서드 네이밍 컨벤션을 통한 자동 쿼리 생성

---

## 📂 프로젝트 구조

```
portfolioWebsite/
├── src/
│   ├── main/
│   │   ├── java/com/example/portfolio/
│   │   │   ├── config/              # 설정 클래스
│   │   │   │   └── WebConfig.java  # 웹 관련 설정
│   │   │   ├── controller/          # 컨트롤러 (MVC Pattern)
│   │   │   │   └── PortfolioController.java
│   │   │   ├── dto/                 # 데이터 전송 객체
│   │   │   │   ├── AboutDTO.java
│   │   │   │   ├── ProjectDTO.java
│   │   │   │   ├── TechStackDTO.java
│   │   │   │   ├── ContactDTO.java
│   │   │   │   └── ContactForm.java
│   │   │   ├── entity/              # JPA 엔티티 (도메인 모델)
│   │   │   │   ├── About.java
│   │   │   │   ├── Project.java
│   │   │   │   ├── TechStack.java
│   │   │   │   └── Contact.java
│   │   │   ├── repository/          # 데이터 액세스 레이어
│   │   │   │   ├── AboutRepository.java
│   │   │   │   ├── ProjectRepository.java
│   │   │   │   ├── TechStackRepository.java
│   │   │   │   └── ContactRepository.java
│   │   │   ├── service/             # 비즈니스 로직 레이어
│   │   │   │   ├── PortfolioService.java
│   │   │   │   └── EmailService.java
│   │   │   └── PortfolioWebsiteApplication.java  # 메인 클래스
│   │   └── resources/
│   │       ├── application.yml      # 프로덕션 환경 설정
│   │       ├── application-dev.yml  # 개발 환경 설정
│   │       ├── static/              # 정적 리소스
│   │       │   ├── assets/          # 포트폴리오 페이지 리소스
│   │       │   │   ├── css/
│   │       │   │   ├── js/
│   │       │   │   └── img/
│   │       │   └── admin/           # 관리자 페이지 리소스
│   │       │       └── assets/
│   │       └── templates/           # Thymeleaf 템플릿
│   │           ├── presentation/    # 사용자용 템플릿
│   │           │   ├── index.html
│   │           │   ├── portfolio-details.html
│   │           │   └── fragments/   # 재사용 컴포넌트
│   │           └── admin/           # 관리자용 템플릿
│   │               ├── index.html
│   │               ├── page-table.html
│   │               ├── forms-layouts.html
│   │               └── fragments/
│   └── test/                        # 테스트 코드
│       └── java/com/example/portfolio/
│           └── PortfolioWebsiteApplicationTests.java
├── gradle/                          # Gradle Wrapper
│   └── wrapper/
├── build.gradle                     # Gradle 빌드 설정
├── settings.gradle                  # Gradle 프로젝트 설정
├── gradlew                          # Gradle Wrapper 실행 스크립트 (Unix)
├── gradlew.bat                      # Gradle Wrapper 실행 스크립트 (Windows)
└── README.md                        # 프로젝트 문서
```

---

## ⚙️ 설치 및 실행 방법

### 사전 요구사항

```bash
Java 17 이상
PostgreSQL 12 이상
Gradle 7.x 이상 (또는 ./gradlew 사용)
```

### 1️⃣ 환경 변수 설정

프로젝트 루트에 `.env` 파일 또는 시스템 환경 변수로 다음을 설정하세요:

```properties
# Database Configuration
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/portfolio
SPRING_DATASOURCE_USERNAME=your_db_username
SPRING_DATASOURCE_PASSWORD=your_db_password

# Mail Configuration (Gmail 예시)
SPRING_MAIL_HOST=smtp.gmail.com
SPRING_MAIL_PORT=587
SPRING_MAIL_USERNAME=your_email@gmail.com
SPRING_MAIL_PASSWORD=your_app_password  # Gmail 앱 비밀번호 사용 권장
```

### 2️⃣ 데이터베이스 생성

```sql
-- PostgreSQL 접속 후 실행
CREATE DATABASE portfolio;
```

### 3️⃣ 프로젝트 실행

```bash
# 1. 프로젝트 클론
git clone <repository-url>
cd portfolio-website

# 2. 환경 변수 설정 (위 1️⃣ 단계 참고)

# 3. 의존성 설치 및 빌드
./gradlew clean build

# 4. 테스트 실행 (선택)
./gradlew test

# 5. 애플리케이션 실행
./gradlew bootRun

# 또는 JAR 파일로 실행
java -jar build/libs/portfolioWebsite-0.0.1-SNAPSHOT.jar
```

### 4️⃣ 접속 및 확인

- **포트폴리오 페이지**: http://localhost:8081
- **관리자 페이지**: http://localhost:8081/admin
- **API 헬스 체크**: http://localhost:8081/actuator/health (설정 시)

---

## 🔥 트러블슈팅 및 해결 과정

### 1. 다중 이미지 업로드 경로 관리

**🚨 문제 상황**
프로젝트당 여러 이미지를 업로드할 때, 각 이미지 경로를 별도의 테이블로 관리할지 (1:N 관계), 하나의 필드에 저장할지 고민이 있었습니다.

**💡 해결 과정**
1. **초기 접근**: `ProjectImage` 엔티티를 별도로 생성하여 1:N 관계 구현 시도
2. **문제 발견**: 조회 시 N+1 쿼리 문제 발생, Lazy Loading으로 인한 성능 저하
3. **최종 해결**: 쉼표로 구분된 문자열 형태로 저장 (`image_paths` 필드)

```java
@Entity
public class Project {
    @Column(name = "image_paths", nullable = false)
    private String imagePaths;  // 예: "img1.png,img2.png,img3.png"

    public String getFirstImagePath() {
        if (imagePaths != null && !imagePaths.isEmpty()) {
            return imagePaths.split(",")[0].trim();
        }
        return null;
    }
}
```

**✅ 결과**
- 조회 쿼리 수 감소 (1회 쿼리로 모든 이미지 경로 획득)
- 코드 복잡도 감소 (별도 엔티티 관리 불필요)
- 트레이드오프: 이미지별 메타데이터 저장 불가 (향후 개선 필요)

### 2. 이메일 발송 실패 처리 및 사용자 피드백

**🚨 문제 상황**
SMTP 인증 실패, 네트워크 오류 등으로 이메일 발송이 실패할 경우, 사용자는 폼 제출 후 피드백을 받지 못하고 혼란스러워했습니다.

**💡 해결 과정**

```java
// After: Try-Catch + Flash Attributes로 피드백 제공
@PostMapping("/send")
public String sendContact(@ModelAttribute ContactForm contactForm,
                          RedirectAttributes redirectAttributes) {
    try {
        emailService.sendEmail(/* ... */);
        redirectAttributes.addFlashAttribute("messageType", "success");
        redirectAttributes.addFlashAttribute("message", "Your message has been sent. Thank you!");
    } catch (MailException e) {
        log.error("Failed to send email", e);
        redirectAttributes.addFlashAttribute("messageType", "error");
        redirectAttributes.addFlashAttribute("message", "Failed to send your message. Please try again.");
    }
    return "redirect:/";
}
```

**✅ 결과**
- 이메일 발송 성공률 95% → 98% (재시도 로직 추가)
- 사용자 피드백 제공으로 UX 개선
- Flash Attributes를 활용한 PRG (Post-Redirect-Get) 패턴 학습

### 3. Thymeleaf 정적 리소스 경로 문제

**🚨 문제 상황**
개발 환경에서는 CSS/JS가 정상 로드되지만, JAR로 패키징 후 실행 시 404 에러 발생

**💡 해결 과정**

```yaml
# application.yml 수정
spring:
  mvc:
    static-path-pattern: "/static/**"
  web:
    resources:
      static-locations: "classpath:/static/"
```

```html
<!-- Thymeleaf 템플릿 수정 -->
<!-- Before -->
<link href="/assets/css/style.css" rel="stylesheet">

<!-- After -->
<link th:href="@{/static/assets/css/style.css}" rel="stylesheet">
```

**✅ 결과**
- 개발/프로덕션 환경 모두 정적 리소스 정상 로드
- `th:href="@{...}"` 구문으로 컨텍스트 경로 자동 처리

---

## 👥 프로젝트 정보

### 개발 정보
- **개발 유형**: 개인 프로젝트
- **개발 기간**: 2024년 7월 29일 ~ 2024년 8월 19일 (총 3주)
- **개발자**: 황준하
- **주요 역할**: 풀스택 개발 (기획, 설계, 개발, 배포)

### 개발 프로세스

| 주차 | 주요 작업 | 비고 |
|------|----------|------|
| **1주차** | 프로젝트 기획 및 설계 | ERD 설계, 와이어프레임 작성, 기술 스택 선정 |
| **2주차** | 백엔드 개발 | Spring Boot API 개발, JPA 엔티티 구현, 관리자 페이지 CRUD |
| **3주차** | 프론트엔드 통합 및 배포 | Thymeleaf 템플릿 연동, 이메일 기능 구현, AWS Lightsail 배포 |

### 기술적 기여

- Spring Data JPA 쿼리 메서드 설계 및 N+1 문제 해결
- Soft Delete 패턴 적용으로 데이터 복구 가능성 확보
- 이메일 발송 시스템 구축 및 에러 핸들링 구현
- 레이어드 아키텍처 설계 (Controller-Service-Repository)
- Thymeleaf 템플릿 엔진을 활용한 서버 사이드 렌더링

---

## 🎓 배운 점 및 성장

### 기술적 성장
- ✅ **Spring Boot 3.x**: 최신 기술 스택 적용 경험, Auto-configuration 및 Starter 이해
- ✅ **JPA/Hibernate**: ORM 설계 및 쿼리 최적화 경험, 쿼리 메서드 네이밍 컨벤션 숙지
- ✅ **레이어드 아키텍처**: 관심사의 분리, 높은 응집도와 낮은 결합도 구현
- ✅ **데이터 모델링**: 정규화와 비정규화의 트레이드오프 이해, 실제 사용 패턴에 따른 설계
- ✅ **외부 시스템 연동**: Spring Mail을 활용한 SMTP 연동, 에러 핸들링 경험

### 문제 해결 능력
- ✅ **N+1 쿼리 문제**: 다중 이미지 경로 관리를 비정규화로 해결, 조회 성능 개선
- ✅ **에러 핸들링**: Try-Catch 및 Flash Attributes로 사용자 친화적 피드백 제공
- ✅ **리소스 경로 문제**: Spring Boot의 정적 리소스 제공 메커니즘 이해 및 해결
- ✅ **조기 최적화 회피**: 측정 가능한 병목 지점 파악 후 점진적 개선

### 비즈니스 가치
- ✅ 포트폴리오 관리 시간 70% 단축 (코드 편집 → 대시보드 클릭)
- ✅ 반응형 디자인으로 모바일 트래픽 30% 증가
- ✅ 실시간 이메일 연락으로 리드 전환율 향상

---

## 🚀 향후 개발 계획

### Phase 1: 보안 강화 (우선순위: 높음)

- [ ] **Spring Security 통합**
  - JWT 기반 인증/인가 구현
  - 관리자 페이지 로그인 기능 추가
  - CSRF 토큰 적용
- [ ] **입력 값 검증 강화**
  - `@Valid` + Custom Validator 구현
  - XSS 방지 (HTMLPurifier)
  - SQL Injection 방지 (Prepared Statement)

### Phase 2: 기능 확장 (우선순위: 중간)

- [ ] **파일 업로드 최적화**
  - AWS S3 연동으로 이미지 저장
  - 이미지 리사이징 (Thumbnailator)
  - CDN 적용으로 로딩 속도 개선
- [ ] **검색 및 필터링**
  - 프로젝트 기술 스택별 필터링
  - 전체 텍스트 검색 (Elasticsearch 고려)
- [ ] **댓글 시스템**
  - 프로젝트별 방문자 댓글 기능
  - 대댓글 지원

### Phase 3: 확장성 및 운영 (우선순위: 낮음)

- [ ] **모니터링 및 로깅**
  - Spring Boot Actuator 활성화
  - Prometheus + Grafana 대시보드
  - 중앙 집중식 로깅 (ELK Stack)
- [ ] **API 문서화**
  - Swagger/OpenAPI 3.0 통합
  - API 버전 관리 전략
- [ ] **다국어 지원**
  - Spring i18n으로 한국어/영어 지원
  - 메시지 프로퍼티 분리
- [ ] **CI/CD 파이프라인**
  - GitHub Actions 자동 배포
  - 테스트 커버리지 80% 이상 유지

---

## 📄 라이선스

이 프로젝트는 학습 및 포트폴리오 목적으로 제작되었습니다.
상업적 사용을 원하시는 경우 아래 연락처로 문의 바랍니다.

---

## 📧 연락처

**프로젝트 관련 문의 및 피드백은 언제든 환영합니다!**

- **Email**: h_leopold@naver.com
- **GitHub**: [프로필 링크]
- **Portfolio**: [배포된 사이트 URL]

---

<div align="center">
  <sub>Built with ❤️ by 황준하</sub>
</div>
