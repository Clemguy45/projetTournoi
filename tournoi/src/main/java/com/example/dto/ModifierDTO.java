package com.example.dto;

import java.util.Date;
import java.util.List;

public record ModifierDTO(Long idJeu, String responsable, String organisation, List<Long> joueursIds, List<Long> equipesIds, List<String> regles, Date date) {
}
