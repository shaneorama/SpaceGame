var scene = new THREE.Scene();
var camera = new THREE.PerspectiveCamera(75, window.innerWidth/window.innerHeight,0.1,1000);
camera.position.z = 5;

var fog = new THREE.Fog(0xAAAAAA, 1, 20);
scene.fog = fog;

var renderer = new THREE.WebGLRenderer({antialias: true});
renderer.setClearColor("#000000");
renderer.setSize(window.innerWidth,window.innerHeight);


document.body.appendChild(renderer.domElement);

window.addEventListener('resize', () => {
    renderer.setSize(window.innerWidth, window.innerHeight);
    camera.aspect = window.innerWidth / window.innerHeight;
    camera.updateProjectionMatrix();
});

renderer.render(scene, camera);

var geometry = new THREE.SphereGeometry(1, 10, 10);
var material = new THREE.MeshLambertMaterial({color: 0xCCFFCC, wireframe: true, vertexColors: true});

var mesh = new THREE.Mesh(geometry, material);

scene.add(mesh);

var light = new THREE.PointLight(0xFFFFFF, 1, 500);
light.position.set(10, 0, 25);

scene.add(light);

var render = function () {
    requestAnimationFrame(render);
    mesh.rotation.x += 0.005;
    mesh.rotation.y += 0.005;
    renderer.render(scene, camera);

};

render();