package com.ppu.taxi.ws.service.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "error")
@XmlType(name = "", propOrder = {"errorName", "errorCode", "errorDesc"})
public class ErrorResponse {
		@XmlElement(name = "errorName", required = true)
		private String errorName;
		
		@XmlElement(name = "errorCode", required = true)
		private Integer errorCode;
		
		@XmlElement(name = "errorDesc", required = true)
		private String errorDesc;

		public String getErrorName() {
			return errorName;
		}

		public void setErrorName(String errorName) {
			this.errorName = errorName;
		}

		public Integer getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(Integer errorCode) {
			this.errorCode = errorCode;
		}

		public String getErrorDesc() {
			return errorDesc;
		}

		public void setErrorDesc(String errorDesc) {
			this.errorDesc = errorDesc;
		}

		@Override
		public String toString() {
			return "ErrorResponse [errorName=" + errorName + ", errorCode="
					+ errorCode + ", errorDesc=" + errorDesc + "]";
		}
		
}
