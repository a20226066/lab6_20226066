package pe.edu.pucp.gtics.charlie.controller;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.pucp.gtics.charlie.entity.*;
import pe.edu.pucp.gtics.charlie.service.CharlieService;
@Controller
public class CharlieController {
 private final CharlieService service;
 public CharlieController(CharlieService service){this.service=service;}
 @GetMapping("/") public String inicio(Model model){model.addAttribute("config",new Configuracion());return "configuracion";}
 @PostMapping("/configurar") public String configurar(@ModelAttribute Configuracion config,HttpSession session,Model model){
   try{session.setAttribute("simulacion",service.crear(config));session.setAttribute("fotosPorActualizacion",config.getFotosPorActualizacion());return "redirect:/simulacion";}
   catch(IllegalArgumentException e){model.addAttribute("error",e.getMessage());return "configuracion";}
 }
 @GetMapping("/simulacion") public String simulacion(HttpSession session,Model model){
   Simulacion s=(Simulacion)session.getAttribute("simulacion"); if(s==null)return "redirect:/";
   model.addAttribute("sim",s); model.addAttribute("cantidad",session.getAttribute("fotosPorActualizacion")); return "simulacion";
 }
 @PostMapping("/avanzar") public String avanzar(@RequestParam(defaultValue="10") int cantidad,HttpSession session){
   Simulacion s=(Simulacion)session.getAttribute("simulacion"); if(s==null)return "redirect:/";
   cantidad=Math.max(1,Math.min(cantidad,20000)); session.setAttribute("fotosPorActualizacion",cantidad); service.avanzar(s,cantidad); return "redirect:/simulacion";
 }
 @PostMapping("/foto20000") public String foto20000(HttpSession session){
   Simulacion s=(Simulacion)session.getAttribute("simulacion"); if(s==null)return "redirect:/";
   if(s.getMovimientos()<20000)service.avanzar(s,20000-s.getMovimientos()); return "redirect:/simulacion";
 }
 @PostMapping("/reiniciar") public String reiniciar(HttpSession session){session.invalidate();return "redirect:/";}
}
