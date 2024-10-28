package pe.edu.trentino.matricula.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.trentino.matricula.dto.ApoderadoDto;

import pe.edu.trentino.matricula.models.Apoderado;

import pe.edu.trentino.matricula.response.PaginatedResponseDto;
import pe.edu.trentino.matricula.response.ResponseDto;
import pe.edu.trentino.matricula.services.ApoderadoService;

import java.io.IOException;


@RequiredArgsConstructor
@RestController
@CrossOrigin()
public class ApoderadoController {

    private final ApoderadoService apoderadoService;
    @PostMapping("/crear-apoderado")
    public ResponseDto crearApoderado(@RequestBody ApoderadoDto dto) {
        return apoderadoService.crearApoderado(dto);
    }

    @GetMapping("/obtener-apoderado")
    public ResponseEntity<PaginatedResponseDto<Apoderado>> obtenerApoderdo(
            @RequestParam(defaultValue = "") String nombre,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int perPage
    ) {
        return ResponseEntity
                .ok(apoderadoService.obtenerApoderado(nombre, page, perPage));
    }
    @PutMapping("/editar-apoderado/{apoderadoId}")
    public ResponseDto editarApoderado(@PathVariable(name = "apoderadoId") Long apoderadoId, @RequestBody ApoderadoDto dto) {
        return apoderadoService.actualizarApoderado(apoderadoId, dto);
    }
    @DeleteMapping("/eliminar-apoderado/{apoderadoId}")
    public ResponseDto eliminarApoderado(@PathVariable(name = "apoderadoId") Long bancoId) {
        return apoderadoService.eliminarApoderado(apoderadoId);
    }
    @GetMapping("/exportar-excel")
    public void exportarExcel(HttpServletResponse response) throws IOException {
        apoderadoService.descargarApoderado(response);
    }
    @PostMapping("/eliminar-todo")
    public ResponseDto eliminarTodosApoderados(@RequestBody Long apoderadoId) {
        var apoderado = "12,23,34";
        //bancoService.eliminarTodosBancos();
        return new ResponseDto(200, "Todos los apoderados han sido eliminados");
    }
}


