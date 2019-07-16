package com.pistis.vdoc.database;

/**
 * Created by Wesley Brenno on 14/05/2016.
 */


import android.content.Context;
import android.util.Log;

import com.pistis.vdoc.entities.Doenca;
import com.pistis.vdoc.entities.Medico;

// TODO: Auto-generated Javadoc

/**
 * The Class DBSPopulater.
 */
public class DBSPopulater {

    /**
     * The m db.
     */
    private static DataBaseStorage mDb;

    /**
     * Instantiates a new DBS populater.
     *
     * @param context the context
     */
    public DBSPopulater(Context context) {
        mDb = new DataBaseStorage(context);
    }

    /**
     * Populate bd.
     */
    public static void populateBD() {

        Doenca pneumonia = new Doenca(1, "Pneumonia", "High fever,Cough,Chest pains,Blood pressure changes,Mental confusion,Generalized ill-being,Shortness of breath,purulent mucus secretion yellowish or greenish,Toxemia (damage caused by toxins borne by the blood),Prostration (weakness))", "Pneumonia is an infection that sets in the lungs (double organ located one on each side of the rib cage). It can affect the region of the pulmonary alveoli where they terminate the terminal branches of the bronchi and sometimes the interstices (space between one alveolus and another).", "Basically, pneumonias are caused by the penetration of an infectious or irritating agent (bacteria, viruses, fungi and by allergic reactions) into the alveolar space, where gas exchange occurs. This place must always be very clean, free of substances that can prevent the contact of the air with the blood.Unlike the influenza virus, which is a highly infectious disease, infectious agents of pneumonia are often not transmitted easily.", "Wash your hands often, especially after: Blowing your nose, going to the bathroom, changing diapers. Also wash your hands before eating or preparing food. Do not smoke. Smoking impairs the lungs' ability to prevent infection. Vaccines can help prevent pneumonia in children, the elderly or people with diabetes, asthma, emphysema, HIV, cancer or other conditions with long-term effects"
                , "Pneumologist");
        Doenca gripe = new Doenca(2, "Gripe", "Fever,Headache,Redness on face,Body pain,tiredness,Muscle pain,Sore throat,Dry cough", "Influenza is an infection of the respiratory system whose main complication is pneumonia, responsible for a large number of hospitalizations in the country. Influenza starts with High Fever, usually above 38 ° C, followed by Muscle pain, Sore throat, Headache and Dry cough", "The flu is caused by the influenza virus", "Flu vaccine is the best way to avoid the flu and its complications", "Pneumologist");
        Doenca gripeH1N1 = new Doenca(3, "Gripe H1N1", "High Fever,Cough,Headache,Muscle aches,Shortness of breath,Sneezing,Sore throat,Weakness,CoryzaNasal congestion,Nausea and vomiting,Diarrhea", "The H1N1 flu consists of a disease caused by a mutation of the influenza virus. Also known as Influenza A or swine flu, it became known when it affected a large part of the world's population between 2009 and 2010.", "The first forms of the H1N1 virus were discovered in pigs, but the mutations that made it became a threat to humans as well. Like all viruses considered to be new, for which there are usually no preventive methods, the mutant H1N1 virus spread rapidly around the world.", "Flu vaccine is the best way to avoid the flu and its complications", "Pneumologist");
        Doenca dengue = new Doenca(4, "Dengue", "High Fever with sudden onset (39 ° to 40 ° C),Strong Headache,Pain behind the eyes,Loss of taste and appetite,Skin blemishes and rashes,Nausea and Vomiting,Dizziness,Extreme tiredness,Body cramps and pain,Many pains in the bones and joints,Abdominal pain", "Dengue is an acute febrile illness caused by a virus and is one of the major public health problems in the world. Its main transmission vector is the Aedes aegypti mosquito, which develops in tropical and subtropical areas.", "Dengue is not transmitted from person to person. The transmission occurs through a mosquito that, after a period of 10 to 14 days after being bitten by someone infected, can carry the dengue virus throughout its life.", "The Aedes aegypti mosquito is the transmitter of the virus and its larvae are born and raised in standing water. Therefore, avoiding these foci of reproduction of this vector is the best way to prevent dengue!", "Infectologist");
        Doenca zika = new Doenca(5, "Zika", "Fever,Headache,Joint pain,Muscle pain,Skin rashes,Conjunctivitis", "Zika Virus is an infection caused by the virus ZIKV, transmitted by the mosquito Aedes aegypti, even transmitting dengue and Fever chikungunya. The Zika virus had its first appearance recorded in 1947, when it was found on monkeys in the Zika Forest in Uganda. However, it was only in 1954 that the first humans were contaminated in Nigeria. The Zika virus hit Oceania in 2007 and France in 2013. Brazil reported the first cases of Zika virus in 2015 in Rio Grande do Norte and Bahia.", "The ZIKV virus is transmitted by a mosquito that can infect a person who has been infected with it and can carry the ZIKV throughout its life, transmitting the disease to a population that does not have antibodies against it.", "he Aedes aegypti mosquito is the transmitter of the virus and its larvae are born and raised in standing water. Therefore, avoiding these foci of this vector reproduction is the best way to prevent against the Zika virus.", "Infectologist");
        Doenca FeverChikungunya = new Doenca(6, "Fever Chinkunguya", "Fever,Pain in the joints,Back pain,Headache,Skin rashes,Fatigue,Nausea,Vomiting,Myalgias", "Fever Chikungunya is a disease similar to dengue fever caused by the CHIKV virus of the Togaviridae family. Its mode of transmission is by the bite of the infected Aedes aegypti mosquito and, less commonly, by the mosquito Aedes albopictus.", "Fever chikugunya is not transmitted from person to person. The contagion is caused by a mosquito that, after a period of seven days after being bitten by someone infected, can carry the CHIKV virus throughout its life, transmitting the disease to a population that does not have antibodies against it. Therefore, the goal is to be alert to block the transmission as soon as the first cases appear.", "The Aedes aegypti mosquito is the transmitter of the virus and its larvae are born and raised in standing water. Therefore, avoiding these foci of this vector reproduction is the best way to prevent Fever chikungunya! ", "Infectologist");
        Doenca hepatite = new Doenca(7, "Hepatitis", "Fever,Headaches,Redness on face,Body pain,tiredness", "Hepatitis refers to any degeneration of the liver due to a variety of causes, being the most common type A, B and C virus infections and the abuse of alcohol or other toxic substances (such as some medicines). While viruses attack the liver when they parasitize their cells for reproduction, cirrhosis of alcoholics is caused by frequent ingestion of alcoholic beverages - once in the body, alcohol is turned into harmful acids into liver cells, leading to hepatitis.", "", "The best strategy for the prevention of hepatitis A includes improving living conditions, adequate sanitation and educational hygiene measures. The specific vaccine against A virus is indicated as recommended by the National Immunization Program (PNI)", "Hepatologist");
        Doenca tuberculose = new Doenca(8, "Tuberculosis", "","Tuberculosis is an infectious disease caused by a bacterium that mainly affects the lungs but can also occur in other organs of the body such as bones, kidneys and meninges (membranes that surround the brain).", "Tuberculosis in general is caused by a Mycobacterium tuberculosis or Koch Bacillus (BK) infection. Other species of mycobacteria can also cause tuberculosis. They are: Mycobacterium bovis, africanum and microti. The transmission of tuberculosis is direct, from person to person, therefore the agglomeration of people is the main transmission factor. The person with tuberculosis expels, when speaking, sneezing or coughing, small drops of saliva that contain the infectious agent and can be aspirated by another individual contaminating it. Poor nutrition, lack of hygiene, smoking, alcoholism or any other factor that causes low organic resistance, also favors the establishment of tuberculosis.", "To prevent tuberculosis it is necessary to immunize the children with the BCG vaccine. Seropositive or newborn infants with signs or symptoms of AIDS should not receive the vaccine. The prevention of tuberculosis includes avoiding agglomerations, especially indoors, and not using objects from contaminated persons.", "Pneumologist");
        Doenca anemia = new Doenca(9, "Anemia", "Fatigue,Weakness,Pale Skin,Dizziness,Cold limbs,Irregular heartbeat,Headache", "", "", "", "");
        Doenca arthritis = new Doenca(10, "Arthritis (Osteoarthritis)", "Joint pain,Tender joints,Stiff joints,Grating joints,Loss of flexibility", "", "", "", "");
        Doenca rheumatic = new Doenca(11, "Arthritis (Rheumatic)", "Tender joints,Morning stiffness,Weight loss,Fatigue,Mild fever (till 98.5)", "", "","","");
        Doenca asthma = new Doenca(12, "Asthma", "Shortness of breath,Chronic coughing,Trouble sleeping at night due to coughing,Chest discomfort","","","","");
        Doenca bronchitis = new Doenca(13, "Bronchitis", "Shortness of breath,Chest discomfort,Coloured/uncoloured sputum cough,Fatigue","","","","");
        Doenca conjunctivitis = new Doenca(14, "Conjunctivitis", "Pink/red colour in white of eyes,Swelling of eyes,Increased tear production","","","","");
        Doenca ear = new Doenca(15, "Ear Infection", "Ear pain,Difficulty in hearing,Fluid drainage from ear","","","","");
        Doenca dermatitis = new Doenca(16,"Dermatitis", "Crust formation on skin,Rashes,Thick patches of red, dry, itchy skin","","","","");
        Doenca diabetes = new Doenca(17, "Diabetes (Type 2)","Fatigue,Frequent urination,Excessive thirst,Blurry vision,Sores and cuts not healing","","","","");
        Doenca epilepsy = new Doenca(18,"Epilepsy", "Seizures,Loss of consciousness,Uncontrollable limb jerking","","","","");
        Doenca influenza = new Doenca(19,"Influenza", "Fatigue,High fever (above 100),Headache,Profuse sweating,Chills,Chronic coughing,Blocked nose","","","","");
        Doenca gallstone = new Doenca(20,"Gallstone", "Pain in upper abdomen,Back pain,Bloating,Heartburn,Nausea,Vomiting","","","","");
        Doenca gout = new Doenca(21,"Gout", "Joint pain,Lingering discomfort,Inflammation of joints","","","","");
        Doenca haemorrhage = new Doenca(22,"Haemorrhage","vomiting,Loss of balance,Loss of consciousness,Slurry speech,Loss of coordination and taste","","","","");
        Doenca hepA = new Doenca(23, "Hepatitis A", "Fatigue,Nausea,Vomiting,Mild fever,Dark urine,Pale stool,Joint pain","","","","");
        Doenca hepB = new Doenca(24,"Hepatitis B","Fatigue,Nausea,Vomiting,Mild fever,Dark urine,Pale stool,Joint pain","","","","");
        Doenca hepC = new Doenca(25,"Hepatitis C", "Fatigue,Nausea,Vomiting,Mild fever,Dark urine,Joint pain","","","","");
        Doenca hernia = new Doenca(26,"Hernia (Incarcerated)","Painful bulge in pubic bone (dark coloured),Sudden pain, quickly intensifies,Rapid heartbeat","","","","");
        Doenca herpes = new Doenca(27, "Herpes", "Mild fever (till 98.5),Headache,Blistery sores near genitals,Itching near genitals","","","","");
        Doenca kidney = new Doenca(28, "Kidney Stone","Colourful urination,Pain during urination,Frequent urination,Back pain","","","","");
        Doenca malaria = new Doenca(29,"Malaria", "Nausea,Vomiting,High fever (above 100),Profuse sweating,Chills,Headache","","","","");
        Doenca osteopo = new Doenca(30, "Osteoporosis","Back pain,Loss of height,Stooped posture", "","","","");
        Doenca pcos = new Doenca(31, "Polycystic Ovary Syndrome (PCOS)", "Excess androgen (husky voice, whiskers),Irregular periods","","","","");
        Doenca parkinson = new Doenca(32, "Parkinson's disease","Tremor in limbs,Rigid muscles,Loss of automatic movement","","","","");
        //Doenca pneumonia = new Doenca(33,"Pneumonia", "Fatigue,Vomiting,Diarrhea,High fever (above 100),Profuse sweating,Chills,Shortness of breath,Chest discomfort,Coloured/uncoloured sputum cough","","","","");
        Doenca psoriasis = new Doenca(33,"Psoriasis", "Thick patches of red, dry, itchy skin,Small scaly spots,Dry skin prone to bleeding", "","","","");
        Doenca ringworm = new Doenca(34,"Ringworm","Severe itching,Loss of hair in affected area,Red ring patch with blisters", "","","","");
        Doenca scabies = new Doenca(35,"Scabies","Itching,Rashes,Crust formation on skin","","","","");
        Doenca meningitis = new Doenca(36,"Streptococcal Meningitis","Moderate fever (98.5-100),High fever (above 100),Sudden fever,Headache,Chills,Loss of appetite,Trouble swallowing,Swollen lymph nodes","","","","");
        Doenca syphilis = new Doenca(37,"Syphilis", "Blistery sores near genitals,Itching near genitals,Trouble swallowing,Painless oozing ulcer", "","","","");
        Doenca utiLow = new Doenca(38, "Urinary Tract Infection (UTI) (lower)","Frequent urination,Pain during urination,Smelly urine,General uneasiness,Cloudy and/or bloody urine","","","","");
        Doenca utiUp = new Doenca(39,"Urinary Tract Infection (UTI) (upper)","Nausea,Vomiting,Diarrhea,High fever (above 100),Chills,Pain during urination","","","","");
        Doenca yellowFever = new Doenca(40,"Yellow Fever","Fatigue,Vomiting,Mild fever (till 98.5),Muscle pain,Loss of appetite,Back pain","","","","");

        mDb.addDoenca(utiLow);
        mDb.addDoenca(utiUp);
        mDb.addDoenca(yellowFever);
        mDb.addDoenca(ringworm);
        mDb.addDoenca(scabies);
        mDb.addDoenca(meningitis);
        mDb.addDoenca(syphilis);
        mDb.addDoenca(pneumonia);
        mDb.addDoenca(gripe);
        mDb.addDoenca(gripeH1N1);
        mDb.addDoenca(dengue);
        mDb.addDoenca(zika);
        mDb.addDoenca(FeverChikungunya);
        mDb.addDoenca(hepatite);
        mDb.addDoenca(tuberculose);
        mDb.addDoenca(anemia);
        mDb.addDoenca(arthritis);
        mDb.addDoenca(rheumatic);
        mDb.addDoenca(asthma);
        mDb.addDoenca(bronchitis);
        mDb.addDoenca(conjunctivitis);
        mDb.addDoenca(ear);
        mDb.addDoenca(dermatitis);
        mDb.addDoenca(diabetes);
        mDb.addDoenca(epilepsy);
        mDb.addDoenca(influenza);
        mDb.addDoenca(gallstone);
        mDb.addDoenca(gout);
        mDb.addDoenca(haemorrhage);
        mDb.addDoenca(hepA);
        mDb.addDoenca(hepB);
        mDb.addDoenca(hepC);
        mDb.addDoenca(hernia);
        mDb.addDoenca(herpes);
        mDb.addDoenca(kidney);
        mDb.addDoenca(malaria);
        mDb.addDoenca(osteopo);
        mDb.addDoenca(pcos);
        mDb.addDoenca(parkinson);
        mDb.addDoenca(psoriasis);

        String horarios = "Segunda-feira à Quinta-feira nos horários de 9:00 às 16:00.";

        Medico medico1 = new Medico(1,"Maria Alzira de Oliveira", "Pneumologist", "Rodrigues Alves, 517 , Bela Vista - Campina Grande", horarios, "(83) 3321-4368", "https://www.google.com.br/maps/place/R.+Rodrigues+Alves,+517+-+Prata,+Campina+Grande+-+PB,+58400-550/@-7.2200938,-35.8994596,17z/data=!3m1!4b1!4m5!3m4!1s0x7ac1e36e1168c81:0x4da8b416a78f4c22!8m2!3d-7.2200991!4d-35.8972709");

        Medico medico2 = new Medico(1,"Sonisa Maria Guimaraes", "Pneumologist", "Praca do Trabalho , 19 , Sao Jose - Campina Grande", horarios, "(83) 3341-3510", "https://www.google.com.br/maps/place/Pra%C3%A7a+do+Trabalho,+19+-+S%C3%A3o+Jos%C3%A9,+Campina+Grande+-+PB,+58400-459/@-7.224647,-35.8943848,17z/data=!3m1!4b1!4m5!3m4!1s0x7ac1e47978b0f11:0x71a3d47ada7340e!8m2!3d-7.2246523!4d-35.8921961");

        Medico medico3 = new Medico(1,"Andrezza Araujo de Oliveira", "Pneumologist", "Rua Rodrigo Alves, 1580 - Bodocongó - Campina Grande", horarios, "(83) 3333-3000", "https://www.google.com.br/maps/place/R.+Rodrigues+Alves,+Campina+Grande+-+PB/@-7.2196504,-35.9015655,17z/data=!3m1!4b1!4m5!3m4!1s0x7ac1e372aa958d9:0x9208d1aecb00bd9!8m2!3d-7.2196557!4d-35.8993768");

        mDb.addMedico(medico3);
        mDb.addMedico(medico1);
        mDb.addMedico(medico2);

        String[] sintomas1 = {"Fever","Headaches","tiredness"};
        String[] sintomas2 = {"seasickness"};


        Log.d("Quantidade de médicos", String.valueOf(mDb.getAllMedicos().size()));

        Log.d("Quantidade de pediatras", String.valueOf(mDb.getMedicoByEspecialidade("Pediatra").size()));

        Log.d("Médico João", mDb.getMedicoByEspecialidade("Pneumologist").get(0).getNome());
        Log.d("Médico José", mDb.getMedicoByEspecialidade("Pneumologist").get(0).getNome());
        Log.d("Médico Douglas", mDb.getMedicoByEspecialidade("Pneumologist").get(0).getNome());

        Log.d("Gripe", mDb.getDoencasBySintomas(sintomas1).get(0).getName());

        Log.d("Quantidades de doenças", String.valueOf(mDb.getDoencasBySintomas(sintomas1).size()));

        Log.d("Quantidades de doenças", String.valueOf(mDb.getDoencasBySintomas(sintomas2).size()));

        Log.d("Quantidades de doenças", String.valueOf(mDb.getAllDoencas().size()));
    }
}