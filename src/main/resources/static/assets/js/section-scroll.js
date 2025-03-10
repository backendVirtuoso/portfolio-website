document.addEventListener('DOMContentLoaded', function() {
    // URL에서 경로를 가져옴
    const path = window.location.pathname;
    
    // 각 섹션에 대한 매핑
    const sectionMapping = {
        '/about': 'about',
        '/tech-stack': 'tech-stack',
        '/projects': 'projects',
        '/contact': 'contact'
    };
    
    // 현재 경로에 해당하는 섹션 ID를 찾음
    const sectionId = sectionMapping[path];
    
    if (sectionId) {
        // 해당 섹션 요소를 찾음
        const section = document.getElementById(sectionId);
        if (section) {
            // 부드러운 스크롤로 해당 섹션으로 이동
            setTimeout(() => {
                section.scrollIntoView({ behavior: 'smooth' });
            }, 100);
        }
    }
}); 