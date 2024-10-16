console.log("Olá mundo");
//alert("Olá mundo")

const toggleButton = document.getElementById('toggleTheme');
const body = document.body;

if(localStorage.getItem('theme') === 'dark'){
    body.classList.add('dark-theme');
} else {
    body.classList.add('light-theme');
}

toggleButton.addEventListener('click', () =>{
    body.classList.toggle('dark-theme');
    body.classList.toggle('light-theme');

    if (body.classList.contains('dark-theme')) {
        localStorage.setItem('theme', 'dark');
    } else {
        localStorage.setItem('theme', 'light');
    }
});

const luscao = document.getElementById('Container');
 
