package com.mariots.biblioteca.bibliotecaadmin.core.service;

import com.mariots.biblioteca.bibliotecaadmin.api.exceptions.RecursoNoEncontradoException;
import com.mariots.biblioteca.bibliotecaadmin.api.exceptions.RecursoNoVinculadoException;
import com.mariots.biblioteca.bibliotecaadmin.api.exceptions.RecursoYaVinculadoException;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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

    @Override
    public TemaSupertema vincularTemaSupertema(int idTema, int idSupertema) {
        TemaEntity temaEntity = repository.recuperarTemaPorId(idTema)
                .orElseThrow(()->new RecursoNoEncontradoException("Id de tema no encontrado "));
        SupertemaEntity supertemaEntity = repository.recuperarSupertemaPorId(idSupertema)
                .orElseThrow(()->new RecursoNoEncontradoException("Id de tema no encontrado "));
        //Comprobamos si el temaEntity tiene ya un Supertema asociado
        if(temaEntity.getSupertema()!=null){
            throw new RecursoYaVinculadoException();
        } else{
            temaEntity.setSupertema(supertemaEntity);
            repository.guardarTema(temaEntity);
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
                .orElseThrow(()->new RecursoNoEncontradoException("Id de tema no encontrado "));
        //Comprobamos si existe previamente el vínculo y si no es así pedimos que no use /sobreescribir
        if(temaEntity.getSupertema()!=supertemaEntity){
            throw new RecursoNoVinculadoException();
        }
        temaEntity.setSupertema(supertemaEntity);
        repository.guardarTema(temaEntity);
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
        //Comprobamos si TextoEntity no tiene temas asociados (en teoría imposible)
        if(textoEntity.getTemas()==null){
            List<TemaEntity> temasEnTexto = Arrays.asList(temaEntity);
            textoEntity.setTemas(temasEnTexto);
            repository.guardarTexto(textoEntity);
        } else{
            //comprobamos si el vínculo existía previamente y si no añadimos el tema al texto
            if(textoEntity.getTemas().stream().anyMatch((tema)->tema==temaEntity)){
                throw new RecursoYaVinculadoException();
            } else{
                List<TemaEntity> temasEnTexto = textoEntity.getTemas();
                temasEnTexto.add(temaEntity);
                textoEntity.setTemas(temasEnTexto);
                repository.guardarTexto(textoEntity);
            }
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
        //Comprobamos si el vínculo texto autor es nulo
        if(textoEntity.getAutor()==null){
            textoEntity.setAutor(autorEntity);
            repository.guardarTexto(textoEntity);
            TextoDto textoDespues = recuperarTextoPorId(idTexto);
            AutorDto autorDespues = recuperarAutorPorId(idAutor);
            return  new TextoAutor(textoDespues,autorDespues);
        } else{
            throw new RecursoYaVinculadoException();
        }
    }

    @Override
    public TextoAutor sobreescribirVinculoTextoAutor(int idTexto, int idAutor) {
        TextoEntity textoEntity = repository.recuperarTextoPorId(idTexto)
                .orElseThrow(() -> new RecursoNoEncontradoException("Id de texto no encontrado"));
        AutorEntity autorEntity = repository.recuperarAutorPorId(idAutor)
                .orElseThrow(() -> new RecursoNoEncontradoException("Id de autor no encontrado"));
        if(textoEntity.getAutor()!=null){
            textoEntity.setAutor(autorEntity);
            repository.guardarTexto(textoEntity);
            TextoDto textoDespues = recuperarTextoPorId(idTexto);
            AutorDto autorDespues = recuperarAutorPorId(idAutor);
            return  new TextoAutor(textoDespues,autorDespues);
        } else{
            throw new RecursoYaVinculadoException();
        }
    }


}