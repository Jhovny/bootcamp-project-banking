/**
 * Resumen.
 * Objeto                   : Account.java
 * Descripción              : Clase de tipo document para obtener o establecer los datos de cada atributo.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un campo nuevo.
 */

package com.nttdata.bootcamp.banking.model.document;

import com.nttdata.bootcamp.banking.util.General;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Clase de tipo document para obtener o establecer los datos de cada atributo.
 */
@Data
@ToString
@Document(collection="account")
public class Account {



    @Id
    private String id;
    private String accountNumber;
    private String accountInterbankNumber;
    private String codeClient;
    private String codeProduct;
    private Date dateRegister;
    private double creditLine;
    private double availableAmount;
    private String codeAccountState;
    private double amountMinimunOpen;
    private int timeElapsedOpen;



    public int getTimeElapsedOpen() {
        LocalDate dateRegisterLocal = this.dateRegister.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

       return timeElapsedOpen =General.calculateTiem(dateRegisterLocal.getDayOfMonth(),
                dateRegisterLocal.getMonthValue(),
                dateRegisterLocal.getYear());

    }

}