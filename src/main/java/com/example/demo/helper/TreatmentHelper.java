package com.example.demo.helper;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.TreatmentDto;
import com.example.demo.model.Client;
import com.example.demo.model.Family;
import com.example.demo.model.Partner;
import com.example.demo.model.Treatment;

public class TreatmentHelper {

    public TreatmentDto mapToDto(Treatment treatment) {
        TreatmentDto treatmentDto = new TreatmentDto();

        treatmentDto.setId(treatment.getId());
        treatmentDto.setPartner_id(treatment.getPartner().getId());

        treatmentDto.setFamily(treatment.getFamily());
//        treatmentDto.setPartner(treatment.getPartner());
        treatmentDto.setIsActive(treatment.getIsActive());
        treatmentDto.setTreatmentName(treatment.getTreatmentName());
        treatmentDto.setProviderName(treatment.getProviderName());
        treatmentDto.setTimeLength(treatment.getTimeLength());
        treatmentDto.setTokenNeeded(treatment.getTokenNeeded());

        return treatmentDto;
    }

    public Treatment mapToEntity(TreatmentDto treatmentDto) {
        Treatment treatment = new Treatment();
        treatment.setId(treatmentDto.getId());
        treatment.setFamily(treatmentDto.getFamily());

        Partner partner = new Partner();
        partner.setId(treatmentDto.getPartner_id());
        treatment.setPartner(partner);

//        treatment.setPartner(treatmentDto.getPartner());
        treatment.setIsActive(treatmentDto.getIsActive());
        treatment.setTreatmentName(treatmentDto.getTreatmentName());
        treatment.setProviderName(treatmentDto.getProviderName());
        treatment.setTimeLength(treatmentDto.getTimeLength());
        treatment.setTokenNeeded(treatmentDto.getTokenNeeded());
        return treatment;
    }

}
