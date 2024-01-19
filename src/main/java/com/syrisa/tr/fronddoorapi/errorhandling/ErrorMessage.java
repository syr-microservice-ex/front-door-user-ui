package com.syrisa.tr.fronddoorapi.errorhandling;

import java.util.Date;

public record ErrorMessage(Date timestamp, String message) {
}
