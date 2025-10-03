package com.example.RegisterLogin.examen;

import org.springframework.stereotype.Service;
import com.example.RegisterLogin.appuser.AppUser;
import com.example.RegisterLogin.appuser.AppUserRepository;
import com.example.RegisterLogin.question.Question;
import com.example.RegisterLogin.question.QuestionRepository;

import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExamenService {

    private final AppUserRepository appUserRepository;
    private final ExamenRepository examenRepository;
    private final QuestionRepository questionRepository;


    //retourne la liste de tous les examens
    public List<Examen> getAllExamens() {

        return examenRepository.findAll();
    }

    //modifie les informations d'un examen
    public Examen modifierExamen(ExamenRequest examen){
        AppUser user = appUserRepository.findById(examen.getCreateurId());
        return examenRepository.save(new Examen(examen.getId(),examen.getIntitule(), examen.getNote_max(), user));
    }

    //retourne un examen avec son id
    public Examen getExamenById(long id) {

        return examenRepository.findById(id).orElseThrow();
    }

    //retourne un examen avec l'id du createur
    public List<Examen> getExamenByCreateurId(long id) {

        return examenRepository.findByCreateurId(id);
    }

    //cree un examen
    public Examen createExamen(Long userId,ExamenRequest request) {
        AppUser user = appUserRepository.findById(userId).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        Examen exam = new Examen( request.getIntitule(), request.getNote_max(), user);
        return examenRepository.save(exam);
    }

    //supprime un examen
    public void deleteExamen(Long id) {

        examenRepository.deleteById(id);
    }

    //retourne la liste des questions dans l'examen
    public List<Question> questions_dans_examen(long examId){
        return questionRepository.findByExamenId(examId);
    }

}
