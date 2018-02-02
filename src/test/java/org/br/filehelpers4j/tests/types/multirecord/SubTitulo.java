/*
 * SubTitulo.java
 *
 * Copyright (C) 2007 Atila Augusto dos Santos - <atila.sistemas@gmail.com>
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.br.filehelpers4j.tests.types.multirecord;

import java.io.Serializable;

import org.br.filehelpers4j.annotations.FieldFixedLength;
import org.br.filehelpers4j.annotations.FieldIgnored;
import org.br.filehelpers4j.annotations.FixedLengthRecord;
import org.br.filehelpers4j.annotations.Seletor;
import org.br.filehelpers4j.enums.FixedMode;
import org.br.filehelpers4j.masterdetail.RecordAction;

@FixedLengthRecord(fixedMode=FixedMode.AllowLessChars)
@Seletor(token="OBM3", type=RecordAction.Detail)
public class SubTitulo implements Serializable{

	/**
	 * 
	 */
	@FieldIgnored
	private static final long serialVersionUID = 5685910427336754464L;
	@FieldFixedLength(8)
	private String campocontrole;
	@FieldFixedLength(13)
	private String codecadobra;
	@FieldFixedLength(15)
	private String codSISRCObra;
	@FieldFixedLength(2)
	private String codtipoTitular;
	@FieldFixedLength(50)
	private String nomeoutrotitular;
	
	
	
	
	
	public SubTitulo() {
	

	}
	
	
	
	public String getCampocontrole() {
		return campocontrole;
	}
	public void setCampocontrole(String campocontrole) {
		this.campocontrole = campocontrole;
	}
	public String getCodecadobra() {
		return codecadobra;
	}
	public void setCodecadobra(String codecadobra) {
		this.codecadobra = codecadobra;
	}
	public String getCodSISRCObra() {
		return codSISRCObra;
	}
	public void setCodSISRCObra(String codSISRCObra) {
		this.codSISRCObra = codSISRCObra;
	}
	public String getCodtipoTitular() {
		return codtipoTitular;
	}
	public void setCodtipoTitular(String codtipoTitular) {
		this.codtipoTitular = codtipoTitular;
	}
	public String getNomeoutrotitular() {
		return nomeoutrotitular;
	}
	public void setNomeoutrotitular(String nomeoutrotitular) {
		this.nomeoutrotitular = nomeoutrotitular;
	}



	@Override
	public String toString() {
		return "SubTitulo [campocontrole=" + campocontrole + ", codecadobra=" + codecadobra + ", codSISRCObra="
				+ codSISRCObra + ", codtipoTitular=" + codtipoTitular + ", nomeoutrotitular=" + nomeoutrotitular + "]";
	}
	
	
	
	
	
	
}
