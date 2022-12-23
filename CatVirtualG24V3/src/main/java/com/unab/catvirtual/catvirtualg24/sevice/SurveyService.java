package com.unab.catvirtual.catvirtualg24.sevice;

import com.unab.catvirtual.catvirtualg24.entity.Survey;
import com.unab.catvirtual.catvirtualg24.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;

    public List<Survey> listSurveyes() {
        return surveyRepository.findAll();
    }

    public Survey querySurvey(String id){
        Survey survey;
        Optional<Survey> optional =  surveyRepository.findById(id);

        if(!optional.isEmpty()){
            survey = optional.get();
        }else{
            survey = null;
        }
        return survey;
    }

    public Survey addSurvey(Survey survey){
        try{
            return surveyRepository.save(survey);
        }catch (Exception e){
            return null;
        }
    }

    public Survey saveSurvey(Survey survey){
        //1 Buscamos si la encuesta existe y recuperamos toda su información
        Optional<Survey> opcional = surveyRepository.findById(survey.getId());
        //la encuesta existe
        if (!opcional.isEmpty()){
            Survey surveyDB = opcional.get();
            //2 comparamos si los valores actuales son diferentes a los valores de la encuesta recibido como parametro

            //if (survey.getName()!=null) surveyDB.setName(survey.getName());

            return surveyRepository.save(surveyDB);
        }else{ //el libro no existe
            return null;
        }
    }

    public void deleteSurvey(String id){
        surveyRepository.deleteById(id);
    }

}
