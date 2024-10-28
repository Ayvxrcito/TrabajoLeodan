package pe.edu.trentino.matricula.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.trentino.matricula.dto.ApoderadoDto;
import pe.edu.trentino.matricula.dto.BancoDto;
import pe.edu.trentino.matricula.models.Apoderado;
import pe.edu.trentino.matricula.models.Banco;
import pe.edu.trentino.matricula.repositories.ApoderadoRepository;
import pe.edu.trentino.matricula.response.ResponseDto;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ApoderadoServiceImpl {
    private final ApoderadoRepository apoderadoRepository;
    @Override
    public ResponseDto crearApoderado(ApoderadoDto apoderadoDto) {
        var response = new ResponseDto();
        Optional<Apoderado> existeNombre = ApoderadoRepository.findByNombre(ApoderadoDto.getNombre());
        if (existeNombre.isPresent()) {
            response.setStatus(422);
            response.setMessage(String.format("Ya existe un Apoderado con el nombre %s", ApoderadoDto.getNombre()));
            return response;
        }
}
