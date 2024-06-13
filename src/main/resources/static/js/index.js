document.addEventListener('DOMContentLoaded', () => {
    const dropdowns = document.querySelectorAll('.dropdown');

    dropdowns.forEach(dropdown => {
        const btn = dropdown.querySelector('.dropbtn');
        const content = dropdown.querySelector('.dropdown-content');

        btn.addEventListener('click', (event) => {
            event.stopPropagation();

            if (content.style.display === 'block') {
                content.style.display = 'none';
            } else {
                document.querySelectorAll('.dropdown-content').forEach(dc => {
                    dc.style.display = 'none';
                });
                content.style.display = 'block';
            }

            adjustContainerHeight();
        });

        window.addEventListener('click', () => {
            content.style.display = 'none';
            adjustContainerHeight();
        });
    });

    function adjustContainerHeight() {
        const openDropdown = document.querySelector('.dropdown-content[style="display: block;"]');
        const header = document.querySelector('.header');
        if (openDropdown) {
            const dropdownHeight = openDropdown.offsetHeight;
            header.style.height = ${163.188 + dropdownHeight}px;
        } else {
            header.style.height = 'auto';
        }
    }
});

function selectOption(type, value) {
    if (type === 'country') {
        document.getElementById('selected-country').innerText = value;
    } else if (type === 'period') {
        document.getElementById('selected-period').innerText = value;
    } else if (type === 'dormitory') {
        document.getElementById('selected-dormitory').innerText = value;
    }
}