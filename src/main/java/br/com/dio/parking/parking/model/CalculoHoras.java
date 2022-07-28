package br.com.dio.parking.parking.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public enum CalculoHoras {

	ATE_CINCO_HORAS {
		@Override
		public Double calcular(LocalDateTime entry, LocalDateTime exit) {
			long result = ChronoUnit.HOURS.between(exit, entry);
			System.out.println(entry);
			System.out.println(exit);
			System.out.println(result);
			if (result <= 1) {
				return 5.0;
			}
			if (result > 1 && result <= 5) {
				return result * 5.0;
			}

			return null;

		}
	},
	VINTE_QUATRO_HORAS {
		@Override
		public Double calcular(LocalDateTime entry, LocalDateTime exit) {
			long result = ChronoUnit.HOURS.between(exit, entry);
			System.out.println(result);
			if (result > 5) {
				return result * 7.0;
			}
			return null;
		}
	};

	public abstract Double calcular(LocalDateTime entry, LocalDateTime exit);

}
