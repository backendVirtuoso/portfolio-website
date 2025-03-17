document.addEventListener('DOMContentLoaded', function() {
    // 네비게이션 링크 클릭 이벤트 처리
    document.querySelectorAll('.nav-link').forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            
            // 현재 활성화된 링크의 active 클래스 제거
            document.querySelector('.nav-link.active')?.classList.remove('active');
            
            // 클릭된 링크에 active 클래스 추가
            this.classList.add('active');
            
            // 대상 섹션의 id 가져오기
            const targetId = this.getAttribute('href').replace('#', '');
            
            // 해당 섹션으로 부드럽게 스크롤
            const targetSection = document.getElementById(targetId);
            if (targetSection) {
                targetSection.scrollIntoView({
                    behavior: 'smooth',
                    block: 'start'
                });
                
                // URL 업데이트 (페이지 새로고침 없이)
                const urlPath = targetId === 'hero' ? '/' :
                              targetId === 'services' ? '/skill' : 
                              `/${targetId}`;
                history.pushState(null, '', urlPath);
            }
        });
    });

    // 페이지 로드 시 URL에 섹션이 지정되어 있으면 해당 섹션으로 스크롤
    const path = window.location.pathname.substring(1);
    if (path) {
        const targetId = path === 'skill' ? 'services' : path;
        const targetSection = document.getElementById(targetId);
        if (targetSection) {
            setTimeout(() => {
                targetSection.scrollIntoView({
                    behavior: 'smooth',
                    block: 'start'
                });
                
                // 해당하는 네비게이션 링크 활성화
                document.querySelector(`.nav-link[href="#${targetId}"]`)?.classList.add('active');
            }, 100);
        }
    }
}); 