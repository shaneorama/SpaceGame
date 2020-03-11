import org.denigma.threejs._
import org.denigma.threejs.Color
import org.scalajs.dom.window
import org.scalajs.dom.document

import scala.scalajs.js

object Main {
  def main(args: Array[String]): Unit = {
    val scene = new Scene
    val camera = new PerspectiveCamera(75, window.innerWidth/window.innerHeight)
    camera.position.z = 5
    val fog = new Fog(0xAAAAAA, 1, 20)
    scene.fog = fog
    val renderer = new WebGLRenderer(new WebGLRendererParameters {antialias = true})
    renderer.setClearColor(new Color(0x000000))
    renderer.setSize(window.innerWidth, window.innerHeight)
    document.body.appendChild(renderer.domElement)

    val windowHandler: js.Function1[_,Any] = _ => {
      renderer.setSize(window.innerWidth, window.innerHeight)
      camera.aspect = window.innerWidth / window.innerHeight
      camera.updateProjectionMatrix
    }

    window.addEventListener("resize", windowHandler)

    renderer.render(scene, camera)

    val geometry = new SphereGeometry(1,10,10)
    val material = new MeshLambertMaterial(new MeshLambertMaterialParameters {
      color = 0xCCFFCC
      wireframe = true
    })

    val mesh = new Mesh(geometry, material)

    scene.add(mesh)

    val light = new PointLight(0xFFFFFF, 1, 500)
    light.position.set(10,0,25)
    scene.add(light)

    val render: js.Function1[Double,Any] = _ => {
      window.requestAnimationFrame(render)
      mesh.rotation.x = mesh.rotation.x + 0.0001
      mesh.rotation.y = mesh.rotation.y + 0.0001
      renderer.render(scene, camera)
    }

    render(1)
  }
}
