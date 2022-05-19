Fetch all Queries	

                Can fetch list of queries by calling this endpoint
                URL:		/api/kyselyt/
                Method: 		GET
                Success Response:	Code 200 OK, see Content below
                  {
                            "id": 1,
                           "nimi": "Ruoka",
                            "kuvaus": "Ruoka\r\n",
                            "kysymykset": [
                              {
                                    "kysymysteksti": "Syötkö?",
                                    "pakollinen": false,
                                    "vastaustyyppi": "teksti",
                                   "id": 2
                               },
                            ],
                            "vastaukset": [
                                {
                                    "id": 5,
                                    "vastauskysymykseen": "Juu\n",
                                    "kysymys": {
                                      "kysymysteksti": "Syötkö?",
                                        "pakollinen": false,
                                        "vastaustyyppi": "teksti",
                                        "id": 2
                                  },
                                 "vastaus": "Juu\n"
                                },
                            ],
                          "kysymyksetSize": 1
                      }


Fetch Query by id

                  Can fetch one query by calling this endpoint, where id is queryid
                  URL:		/api/kysely/id
                  Method:		GET
                  URL Params:	Required: id = {integer} 

Fetch all Questions	

                  Can fetch list of all questions by calling this endpoint
                  URL:		/api/kysymykset/
                  Method:		GET
                  Success Response:	Code: 200 OK, see Content below
                    {
                            "kysymysteksti": "Syötkö aamupalan?",
                            "pakollinen": true,
                            "vastaustyyppi": "teksti",
                              "id": 2
                                 },
                                 {
                              "kysymysteksti": "Montako lerta päivässä syöt kunnon annoksia?",
                              "pakollinen": false,
                              "vastaustyyppi": "teksti",
                              "id": 3
                                },
                                {
                              "kysymysteksti": "Mihin aikaan syöt viimeisen annoksen?",
                              "pakollinen": false,
                              "vastaustyyppi": "teksti",
                              "id": 4
                                 }

Fetch Question by id	

                      Can fetch one question by calling this endpoint, where id is questionid
                      URL:		/api/kysymys/id
                      Method:		GET
                      URL Params	Required: id = {integer} 
                      Success Response:	Code: 200 OK, see Content below
                      {
                              "kysymysteksti": "Syötkö aamupalan?",
                              "pakollinen": true,
                              "vastaustyyppi": "teksti",
                              "id": 2
                          }

Fetch Questions by Query id

                      Can fetch all questions of one query by calling this endpoint, where id is queryid
                      URL: 		/api/kysymykset/kysely/id
                      Method:		GET
                      URL Params	Required: id = id {integer} 
                      Success Response:	Code: 200 OK, see Content below
                      {
                              "kysymysteksti": "Syötkö aamupalan?",
                              "pakollinen": true,
                              "vastaustyyppi": "teksti",
                              "id": 2
                          },
                          {
                              "kysymysteksti": "Montako lerta päivässä syöt kunnon annoksia?",
                              "pakollinen": false,
                              "vastaustyyppi": "teksti",
                              "id": 3
                          },
                          {
                              "kysymysteksti": "Mihin aikaan syöt viimeisen annoksen?",
                              "pakollinen": false,
                              "vastaustyyppi": "teksti",
                              "id": 4
                          }

Fetch all Answers	

                      Can fetch all Questions by calling this endpoint
                      URL:		/api/vastaukset/
                      Method:		GET
                      Success Response:	Code 200 OK, see Content below
                      {
                              "id": 5,
                              "vastauskysymykseen": "juu",
                              "kysymys": {
                                  "kysymysteksti": "Syötkö?",
                                  "pakollinen": false,
                                  "vastaustyyppi": "teksti",
                                  "id": 2
                              },
                              "vastaus": "juu"
                          },
                          {
                              "id": 6,
                              "vastauskysymykseen": "en",
                              "kysymys": {
                                  "kysymysteksti": "Juotko?",
                                  "pakollinen": false,
                                  "vastaustyyppi": "teksti",
                                  "id": 3
                              },
                              "vastaus": "en"
                          },
                          {
                              "id": 7,
                              "vastauskysymykseen": "joskus",
                              "kysymys": {
                                  "kysymysteksti": "Nukutko?",
                                  "pakollinen": false,
                                  "vastaustyyppi": "teksti",
                                  "id": 4
                              },
                              "vastaus": "joskus"
                          }

Add Answer 
		
                      URL: 		/api/vastaukset/
                      Method:		POST
                          headers: {
                                        'Accept': 'application/json',
                                        'Content-Type': 'application/json'}
                                   } 
                        Body: 
                          {

                                "vastauskysymykseen": "kyllä",
                                  "kysymys": "https://thirdgearbcknd.herokuapp.com/api/kysymyses/2",
                                  "vastaus": "kyllä"

                              }



Get a PDF file of all Answers

                        URL: 		/api/vastaukset
                        Method: 		GET
                        headers: {
                                  'Content-Type': 'application/pdf'
                        }

