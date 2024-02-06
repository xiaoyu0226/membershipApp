package com.example.demo.helper;

import com.example.demo.dto.FamilyDto;
import com.example.demo.dto.RedemptionDto;
import com.example.demo.dto.TreatmentDto;
import com.example.demo.model.Family;
import com.example.demo.model.Redemption;
import com.example.demo.model.Treatment;

public class RedemptionHelper {

    public RedemptionDto mapToDto(Redemption redemption) {
        RedemptionDto redemptionDto = new RedemptionDto();
        redemptionDto.setId(redemption.getId());

        redemptionDto.setFamily_id(redemption.getFamily().getId());
        redemptionDto.setTreatment_id(redemption.getTreatment().getId());
        redemptionDto.setTokenConsumed(redemption.getTokenConsumed());
        return redemptionDto;
    }

    private Redemption mapToEntity(RedemptionDto redemptionDto) {
        Redemption redemption = new Redemption();
        redemption.setId(redemptionDto.getId());

        Family family = new Family();
        family.setId(redemptionDto.getFamily_id());

        Treatment treatment = new Treatment();
        treatment.setId(redemptionDto.getTreatment_id());

        redemption.setFamily(family);
        redemption.setTreatment(treatment);
        redemption.setTokenConsumed(redemptionDto.getTokenConsumed());
        return redemption;
    }
}
