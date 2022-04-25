package com.mariots.biblioteca.bibliotecaadmin.core.service;

import com.mariots.biblioteca.bibliotecaadmin.api.exceptions.RecursoNoEncontradoException;
import com.mariots.biblioteca.bibliotecaadmin.api.exceptions.RecursoNoVinculadoException;
import com.mariots.biblioteca.bibliotecaadmin.api.exceptions.RecursoYaVinculadoException;
import com.mariots.biblioteca.bibliotecaadmin.api.exceptions.RepetirVinculoException;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.AutorDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.SupertemaDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.TemaDto;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.TextoDto;
import com.mariots.biblioteca.bibliotecaadmin.api.mapper.Mapper;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.objetosvinculados.TemaSupertema;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.objetosvinculados.TextoAutor;
import com.mariots.biblioteca.bibliotecaadmin.core.dtos.objetosvinculados.TextoTema;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.AutorEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.SupertemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.TemaEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.entities.TextoEntity;
import com.mariots.biblioteca.bibliotecaadmin.persistence.repository.RepositoryBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServiceBibliotecaImpl implements ServiceBiblioteca {
    @Autowired
    RepositoryBiblioteca repository;
   @Autowired
    Mapper mapper;

//MÉTODOS GUARDAR
    @Override
    public AutorDto guardarAutor(AutorDto autorDto) {
        return mapper.toDto(repository.guardarAutor(mapper.toEntity(autorDto)));
    }

    @Override
    public TemaDto guardarTema(TemaDto temaDto) {
        return mapper.toDto(repository.guardarTema(mapper.toEntity(temaDto)));
    }

    @Override
    public SupertemaDto guardarSupertema(SupertemaDto supertemaDto) {
        return mapper.toDto(repository.guardarSupertema(mapper.toEntity(supertemaDto)));
    }

    @Override
    public TextoDto guardarTexto(TextoDto textoDto) {
        return mapper.toDto(repository.guardarTexto(mapper.toEntity(textoDto)));
    }

//MÉTODOS RECUPERAR TODOS
    @Override
    public List<AutorDto> recuperarAutores() {
        return repository.recuperarAutores().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<TemaDto> recuperarTemas() {
        return repository.recuperarTemas().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SupertemaDto> recuperarSupertemas() {
        return repository.recuperarSupertemas().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<TextoDto> recupearTextos() {
        return repository.recupearTextos().stream().map(mapper::toDto).collect(Collectors.toList());
    }

//MÉTODOS RECUPERAR POR ID
    @Override
    public AutorDto recuperarAutorPorId(int idAutor) {
        return repository.recuperarAutorPorId(idAutor).map(mapper::toDto).orElseThrow(()->new RecursoNoEncontradoException("Id de Autor no encontrado"));
    }

    @Override
    public TemaDto recuperarTemaPorId(int idTema) {
        return repository.recuperarTemaPorId(idTema).map(mapper::toDto).orElseThrow(()->new RecursoNoEncontradoException("Id de Tema no encontrado"));
    }

    @Override
    public SupertemaDto recuperarSupertemaPorId(int idSupertema) {
        return repository.recuperarSupertemaPorId(idSupertema).map(mapper::toDto).orElseThrow(()->new RecursoNoEncontradoException("Id de Supertema no encontrado"));
    }

    @Override
    public TextoDto recuperarTextoPorId(int idTexto) {
        return repository.recuperarTextoPorId(idTexto).map(mapper::toDto).orElseThrow(()->new RecursoNoEncontradoException("Id de Texto no encontrado"));
    }

    @Override
    public AutorDto recuperarAutorPorNombre(String nombreAutor) {
        return repository.recuperarAutorPorNombre(nombreAutor).map(mapper::toDto).orElseThrow(()->new RecursoNoEncontradoException("Nombre de Autor no encontrado"));
    }

    @Override
    public TemaDto recuperarTemaPorNombre(String nombreTema) {
        return repository.recuperarTemaPorNombre(nombreTema).map(mapper::toDto).orElseThrow(()->new RecursoNoEncontradoException("Nombre de Tema no encontrado"));    }

    @Override
    public SupertemaDto recuperarSupertemaPorNombre(String nombreSupertema) {
        return repository.recuperarSupertemaPorNombre(nombreSupertema).map(mapper::toDto).orElseThrow(()->new RecursoNoEncontradoException("Nombre de Supertema no encontrado"));
    }
//MÉTODOS AÑADIR VÍNCULOS
    @Override
    public TemaSupertema vincularTemaSupertema(int idTema, int idSupertema) {
        TemaEntity temaEntity = repository.recuperarTemaPorId(idTema)
                .orElseThrow(()->new RecursoNoEncontradoException("Id de tema no encontrado "));
        SupertemaEntity supertemaEntity = repository.recuperarSupertemaPorId(idSupertema)
                .orElseThrow(()->new RecursoNoEncontradoException("Id de tema no encontrado "));
        //Comprobamos si el supertema de temaEntity es null, si lo es añadimos vínculo
        if(temaEntity.getSupertema()==null){
            temaEntity.setSupertema(supertemaEntity);
            repository.guardarTema(temaEntity);
            //Comprobamos si el vinculo existe previamente para no generar duplicados
        } else if (temaEntity.getSupertema()==supertemaEntity) {
            throw new RepetirVinculoException();
            //si no es nulo ni existe el vínculo previamente, entonces existe un vínculo y hay que sobreescribir
        } else{
            throw new RecursoYaVinculadoException();
        }
        TemaDto temaDespues = recuperarTemaPorId(idTema);
        SupertemaDto supertemaDespues =recuperarSupertemaPorId(idSupertema);
        return new TemaSupertema(temaDespues,supertemaDespues);
    }

    @Override
    public TemaSupertema sobreescribirVinculoTemaSupertema(int idTema, int idSupertema) {
        TemaEntity temaEntity = repository.recuperarTemaPorId(idTema)
                .orElseThrow(()->new RecursoNoEncontradoException("Id de tema no encontrado "));
        SupertemaEntity supertemaEntity = repository.recuperarSupertemaPorId(idSupertema)
                .orElseThrow(()->new RecursoNoEncontradoException("Id de supertematema no encontrado "));
        //Comprobamos que el supertema de tema no es null
        if(temaEntity.getSupertema()==null){
            throw new RecursoNoVinculadoException();
            //Comprobamos si existe previamente el vínculo para no generar duplicados
        } else if(temaEntity.getSupertema()==supertemaEntity) {
            throw new RepetirVinculoException();
        } else{
            temaEntity.setSupertema(supertemaEntity);
            repository.guardarTema(temaEntity);
        }
        TemaDto temaDespues = recuperarTemaPorId(idTema);
        SupertemaDto supertemaDespues =recuperarSupertemaPorId(idSupertema);
        return new TemaSupertema(temaDespues,supertemaDespues);
    }

    @Override
    public TextoTema vincularTextoTema(int idTexto, int idTema) {
        TextoEntity textoEntity = repository.recuperarTextoPorId(idTexto)
                .orElseThrow(()->new RecursoNoEncontradoException("Id de texto no encontrado"));
        TemaEntity temaEntity= repository.recuperarTemaPorId(idTema)
                .orElseThrow(()->new RecursoNoEncontradoException("Id de tema no encontrado"));
        //Comprobamos si TextoEntity no tiene temas asociados (en teoría imposible), si lo es se añade vínculo
        if(textoEntity.getTemas()==null){
            List<TemaEntity> temasEnTexto = Arrays.asList(temaEntity);
            textoEntity.setTemas(temasEnTexto);
            repository.guardarTexto(textoEntity);
            //comprobamos si el vínculo existía previamente para evitar duplicados
        } else if(textoEntity.getTemas().stream().anyMatch((tema)->tema==temaEntity)){
            throw new RepetirVinculoException();
        } else{
            List<TemaEntity> temasEnTexto = textoEntity.getTemas();
            temasEnTexto.add(temaEntity);
            textoEntity.setTemas(temasEnTexto);
            repository.guardarTexto(textoEntity);
        }
        TextoDto textoDespues = recuperarTextoPorId(idTexto);
        TemaDto temaDespues = recuperarTemaPorId(idTema);
        return new TextoTema(textoDespues,temaDespues);
    }

    @Override
    public TextoAutor vincularTextoAutor(int idTexto, int idAutor) {
        TextoEntity textoEntity = repository.recuperarTextoPorId(idTexto)
                .orElseThrow(() -> new RecursoNoEncontradoException("Id de texto no encontrado"));
        AutorEntity autorEntity = repository.recuperarAutorPorId(idAutor)
                .orElseThrow(() -> new RecursoNoEncontradoException("Id de autor no encontrado"));
        //Comprobamos si el vínculo texto autor es nulo, si lo es se añade y guarda
        if(textoEntity.getAutor()==null){
            textoEntity.setAutor(autorEntity);
            repository.guardarTexto(textoEntity);
            //comprobamos si el vínculo que se quiere crear ya existe para eviar repeticiones
        } else if (textoEntity.getAutor()==autorEntity) {
            throw new RepetirVinculoException();
        } else{
            throw new RecursoYaVinculadoException();
        }
        TextoDto textoDespues = recuperarTextoPorId(idTexto);
        AutorDto autorDespues = recuperarAutorPorId(idAutor);
        return  new TextoAutor(textoDespues,autorDespues);
    }

    @Override
    public TextoAutor sobreescribirVinculoTextoAutor(int idTexto, int idAutor) {
        TextoEntity textoEntity = repository.recuperarTextoPorId(idTexto)
                .orElseThrow(() -> new RecursoNoEncontradoException("Id de texto no encontrado"));
        AutorEntity autorEntity = repository.recuperarAutorPorId(idAutor)
                .orElseThrow(() -> new RecursoNoEncontradoException("Id de autor no encontrado"));
        //comprobamos si el autor es null
        if(textoEntity.getAutor()==null){
            throw new RecursoNoVinculadoException();
            //comprobamos si el vínculo ya existía para no duplicar elementos de vínculo
        } else if(textoEntity.getAutor()==autorEntity){
            throw new RepetirVinculoException();
            //si no existe previamente se añade
        } else {
            textoEntity.setAutor(autorEntity);
            repository.guardarTexto(textoEntity);
        }
        TextoDto textoDespues = recuperarTextoPorId(idTexto);
        AutorDto autorDespues = recuperarAutorPorId(idAutor);
        return  new TextoAutor(textoDespues,autorDespues);
    }

//MÉTODOS ELIMINAR RECURSO
    @Override
    public void eliminarAutorPorId(int idAutor) {
        AutorEntity autorEntity = repository.recuperarAutorPorId(idAutor)
                .orElseThrow(()->new RecursoNoEncontradoException("Id de autor no encontrado"));
        repository.eliminarAutor(autorEntity);
    }
    @Override
    public void eliminarTextoPorId(int idTexo) {
        TextoEntity textoEntity = repository.recuperarTextoPorId(idTexo)
                .orElseThrow(()->new RecursoNoEncontradoException("Id de texto no encontrado"));
        repository.eliminarTexto(textoEntity);
    }
    @Override
    public void eliminarTemaPorId(int idTema) {
        TemaEntity temaEntity = repository.recuperarTemaPorId(idTema)
                .orElseThrow(()->new RecursoNoEncontradoException("Id de tema no encontrado"));
        repository.eliminarTema(temaEntity);

    }
    @Override
    public void eliminarSupertemaPorId(int idSupertema) {
        SupertemaEntity supertemaEntity = repository.recuperarSupertemaPorId(idSupertema)
                .orElseThrow(()->new RecursoNoEncontradoException("Id de supertema no encontrado"));
        repository.eliminarSupertema(supertemaEntity);
    }


}