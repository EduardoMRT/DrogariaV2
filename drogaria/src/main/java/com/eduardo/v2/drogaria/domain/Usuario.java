package com.eduardo.v2.drogaria.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "usuario")
@Entity(name = "usuario")
@Getter
@Setter
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codUsuario;

    @Column(nullable = false, length = 128)
    private String senha;

    @Column(nullable = false)
    private Character tipo;

    @Column(nullable = false)
    private Boolean ativo;

    @OneToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

    @Column(nullable = true)
    private String senhaTemporaria;

    @Transient //diz que esse método só serve para formatação
    public String getTipoFormatado(){
        String tipoFormatado = null;
        if(tipo == 'A') {
            tipoFormatado = "Administrador";
        }else if(tipo == 'B') {
            tipoFormatado = "Balconista";
        }else if(tipo == 'G'){
            tipoFormatado = "Gerente";
        }

        return tipoFormatado;
    }

    public String getAtivoFormatado() {
        String ativoFormatado = null;
        if(ativo == true) {
            ativoFormatado = "Sim";
        }else {
            ativoFormatado = "Não";
        }
        return ativoFormatado;
    }

}
