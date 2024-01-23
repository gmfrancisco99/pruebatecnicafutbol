package com.gastonmunoz.pruebaTecnicaFutbol.service;


import com.gastonmunoz.pruebaTecnicaFutbol.entity.Equipo;
import com.gastonmunoz.pruebaTecnicaFutbol.exception.EquipoNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Sql(statements = "DROP TABLE EQUIPOS", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts={"classpath:schema.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts={"classpath:test_equipos.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@SpringBootTest
public class EquipoServiceImplTest {

    @Autowired
    private EquipoService equipoService;

    @Test
    public void whenGetByValidID_thenReturnEquipo(){
        Integer equipoID = 1;
        Equipo found = equipoService.getEquipoById(equipoID);
        assertThat(found.getId()).isEqualTo(equipoID);
    }

    @Test
    public void whenGetByNotFoundID_thenReturnEquipoNotFoundException(){
        Integer notFoundID = 50;
        assertThrows(EquipoNotFoundException.class, ()-> equipoService.getEquipoById(notFoundID));
    }

    @Test
    public void whenGetAllEquipos_thenReturnEquipoList(){
        List<Equipo> equipoList = equipoService.getAllEquipos();
        assertThat(equipoList).isNotEmpty();
        assertThat(equipoList.size()).isEqualTo(10);

        assertThat(equipoList.get(0).getPais()).isEqualTo("España");
    }

    @Test
    public void whenGetAllEquiposByFoundNombre_thenReturnEquipoList(){
        String nombreEquipo = "Madrid";
        List<Equipo> equipoList = equipoService.getAllEquiposByNombre(nombreEquipo);
        assertThat(equipoList).isNotEmpty();
        assertThat(equipoList.size()).isEqualTo(2);
    }

    @Test
    public void whenGetAllEquiposByNotFoundNombre_thenReturnEmptyList(){
        String notFoundNombre = "asdflasdfadsf";
        List<Equipo> equipoList = equipoService.getAllEquiposByNombre(notFoundNombre);
        assertThat(equipoList).isEmpty();
    }

    @Test
    public void whenUpdateFoundEquipoWithValidEquipo_thenReturnUpdatedEquipo(){
        Equipo updateEquipo = new Equipo(1, "Nuevo Nombre", "Nueva Liga", "Nuevo Pais");

        Equipo getEquipo = equipoService.getEquipoById(1);
        assertThat(getEquipo.getNombre()).isEqualTo("Real Madrid");
        assertThat(getEquipo.getLiga()).isEqualTo("La Liga");
        assertThat(getEquipo.getPais()).isEqualTo("España");

        Equipo updatedEquipo = equipoService.updateEquipo(updateEquipo.getId(), updateEquipo);
        assertThat(updatedEquipo.getNombre()).isEqualTo(updateEquipo.getNombre());
        assertThat(updatedEquipo.getLiga()).isEqualTo(updateEquipo.getLiga());
        assertThat(updatedEquipo.getPais()).isEqualTo(updateEquipo.getPais());
    }

    @Test
    public void whenUpdateNotFoundEquipo_thenReturnEquipoNotFoundException(){
        Equipo updateEquipo = new Equipo(1, "Nuevo Nombre", "Nueva Liga", "Nuevo Pais");

        assertThrows(EquipoNotFoundException.class, ()-> equipoService.updateEquipo(50, updateEquipo));
    }

    @Test
    public void whenDeleteFoundEquipo_thenEquipoIsNotFoundAfter(){
        Equipo equipoToDelete = equipoService.getEquipoById(1);
        assertThat(equipoToDelete).isNotNull();
        assertThat(equipoToDelete.getNombre()).isEqualTo("Real Madrid");
        assertThat(equipoToDelete.getLiga()).isEqualTo("La Liga");
        assertThat(equipoToDelete.getPais()).isEqualTo("España");

        equipoService.deleteEquipoById(1);
        assertThrows(EquipoNotFoundException.class, ()->{
            equipoService.getEquipoById(1);
        });

    }
    @Test
    public void whenDeleteNotFoundEquipo_thenReturnEquipoNotFoundException(){
        Integer notFoundID = 50;
        assertThrows(EquipoNotFoundException.class, ()-> equipoService.deleteEquipoById(notFoundID));
    }
}
