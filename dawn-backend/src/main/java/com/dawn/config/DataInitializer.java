package com.dawn.config;

import com.dawn.domain.*;
import com.dawn.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;
    private final KeywordRepository keywordRepository;
    private final UserRepository userRepository;
    private final LetterRepository letterRepository;
    private final StampRepository stampRepository;
    private final VisitedRepository visitedRepository;
    private final CommentReportRepository commentReportRepository;
    private final ChatRepository chatRepository;

    @Override
    public void run(String... args) {
        Event event1 = eventRepository.save(Event.builder()
                .name("5.18 광주민주화운동")
                .shortInfo("1980년 5월 18일 광주에서 신군부 세력을 거부하고 민주화를 요구하여 일어난 시민봉기.")
                .background("1979년  10월 26일,  중앙정보부장  김재규가  박정희  대통령을 암살한  10·26 사건으로  유신 체제는 막을 내렸다.  유신헌법을 개정하고 민주적인 헌법으로 되돌아야 한다는 움직임 속에서,  최규하  대통령은  11월 7일에  긴급조치를 해제해 긴급조치에 의해 금지됐던 개헌 논의를 허용했다. 하지만  12월 12일에  계엄사령부  합동수사본부장  전두환  보안사령관이 계엄사령관  정승화(육군 참모총장)를 체포해 쿠데타를 일으킴으로써, 국민들의 민주 정권 수립 요구는 결국 이루어지지 못했다. 전두환은 1980년 2월에 보안사령부에 지시를 내려  K-공작계획을 실행해 민주화 여론을 잠재우고 군부의 정치 참여를 정당화하는 방향으로 여론을 조성해 나가고 있었다.\\n1980년  5월에 초순경 보안사령관 겸 중앙정보부장 서리 전두환의 지시에 따라  보안사에서는 국회와 내각을 무력화하고 정권을 장악하려는 의도에서 '비상계엄 전국확대', '국회 해산', '국가보위 비상기구 설치' 등을 골자로 하는 집권 시나리오로 '시국수습방안'을 기획했다. 비상계엄 확대조치와 국가보위 비상기구를 설치해 신군부에 대한 국민의 저항을 탄압하면서 신군부가 정국을 주도하고, 국회 폐쇄와 정치인 체포로 신군부의 안정적인 정국 장악을 담보한다는 것이 시국수습방안을 기획한 의도였다.\\n중앙정보부는 일본 내각조사실의 첩보를 토대로 5월 10일에 대북 특이동향을 경고하는 보고서, '북괴남침설'을 작성했고,  5월 12일  심야에 임시 국무회의에서 관련 내용을 보고했다. 육군본부 정보참모부는 5월 11일에 '북괴남침설'과 같은 첩보는 가치가 없다고 결론 내린 상황이었다.  주한미군  사령관  존 위컴은  5월 13일에 '북괴남침설'은 근거가 없으며, 전두환이  청와대의 주인이 되기 위해 흘린 구실이라고 본국에 보고했다. 미국 국무부 대변인은 같은 날에 미국은 '북괴남침설'과 관련된 어떤 정보도 입수하지 못했다고 발표했다. 훗날 남침설을 제보했다고 알려진 당시 일본의 내각 조사실 한반도 담당반장은 \"그런 구체적인 내용을 말한 적도, 그런 정보도 없었다.\"라고 밝혀 신군부가 집권을 정당화하기 위해 악용했던 '북괴남침설'은 신군부로 말미암아 조작된 것으로 드러났다.\\n한편 같은해 5월 중순부터 정부와 국회에서는 민주화 일정을 앞당기고 있었다. 5월 12일에 신민당과  공화당  양당 총무들은 개헌안을 접수하였고, 비상계엄 해제 등의 정치 현안을 논의하기 위해 5월 20일 10시 임시국회의 소집을 공고했다. 같은날  신현확  총리는 국회와 협의를 통해 헌법을 개정하고, 개헌 일정을 앞당긴다는 내용의 담화를 발표했다.\\n1980년 5월 초부터 신군부 세력의 정치 관여를 반대하기 위해, 학생과 시민 10만여 명이 모여  서울역에서 시위를 벌였고, 5월 15일 시위대 대열 속에 속했던 청년 한 명이 버스를 탈취하여 저지선을 돌파, 전경에 돌진하여 전경 이성재 일경이 사망하고 4명이 중상을 입는 사고가 발생했다.  신군부는 5월 17일 24시에  5·17 비상계엄 전국확대 조치를 내려 18일 1시 자로 계엄령이 전국으로 확대됐다. 신군부는 같은 날 새벽 2시에 국회를 무력으로 봉쇄해 헌정중단 사태가 발생했다. 김대중, 김종필 등 정치인 26명은 합동수사본부로 연행됐고, 2,600여 명의 학생·교수·재야인사 등이 체포됐다. 신민당 총재  김영삼은 무장헌병들에게 가택 연금됐다. 신군부가 이날 내린 비상계엄 전국확대 조치·정치 활동 금지·휴교령 등의 민주주의 역행 조치에 항의해,  전남대학교  학생들은 5월 18일 오전에 학교 정문 앞에서 시위를 했고,  공수부대는 학생들을 구타·폭행으로 진압했다. 과격한 공수부대의 투입은 5·18 광주 민주화 운동의 직접적인 원인이 됐다.")
                .progress("1980년 5월, 신군부 세력이 정권 장악을 본격화하면서 민주화를 요구하는 국민들과의 충돌이 본격적으로 시작되었다.\\n5월 15일, 광주에서는 3만여 명의 대학생들이 전남도청 앞에 모여 시국선언문을 낭독하고 대규모 가두시위를 벌였다. 학생 지도부는 16일에도 시위를 이어가기로 결의했으나, 5월 17일 밤 신군부의 압력으로 열린 비상국무회의에서 전국적인 비상계엄 확대가 결정되면서 상황은 급변했다.\\n\\n그날 밤 야당 정치인 김대중, 김영삼, 김종필 등이 체포되었고, 군은 국회를 점령하며 헌정 질서를 사실상 마비시켰다. 18일 새벽, 계엄포고령 제10호가 공표되어 전국 대학에 휴교령이 내려졌고, 언론은 검열되었으며 정치활동은 전면 금지되었다. 제7공수여단은 곧바로 광주에 진입하여 전남대학교와 조선대학교를 점령하고 학생들의 출입을 차단했다.\\n\\n5월 18일 아침, 전남대학교 정문 앞에서 학생들과 공수부대 간의 첫 충돌이 발생했다. 일부 학생들은 시내로 진출하여 금남로에서 시민들과 함께 시위를 이어갔고, 경찰은 최루탄을 사용해 해산을 시도했다. 그러나 같은 날 오후, 계엄군은 도심으로 제7공수여단을 투입하여 학생뿐만 아니라 일반 시민들에게도 무차별적인 폭력을 가하기 시작했다.\\n\\n5월 19일부터 시위는 더욱 확산되었다. 대학생 중심의 시위에 분노한 고등학생들과 일반 시민들이 참여하면서 시위 규모는 더욱 커졌다. 20일에는 약 20만 명이 넘는 시민들이 시위에 동참했고, 택시와 버스 기사들도 계엄군의 진입을 막기 위해 차량을 동원했다. 그러나 계엄군은 곤봉과 총 개머리판, 대검을 이용해 남녀노소를 가리지 않고 폭력을 행사했다. 계엄군의 진압은 점점 가혹해졌고, 광주 MBC 방송국이 시위대에 의해 방화되는 등 상황은 격화되었다.\\n\\n5월 20일 밤, 광주역 앞에서 계엄군이 최초의 집단 발포를 감행했다. 이는 이후 21일의 대규모 학살로 이어지는 전환점이 되었다. 5월 21일 정오, 전남도청과 전남대학교 앞에서 계엄군은 시위대를 향해 본격적인 무차별 사격을 시작했다. 이후 전일빌딩, 광주관광호텔 등의 고층 건물 옥상에서 조준사격이 이루어졌고, 수많은 시민들이 목숨을 잃었다. 병원과 보건소는 감당할 수 없는 수준의 사상자들로 넘쳐났다.\\n\\n이날 오후부터 시민들은 무장하기 시작했다. 나주와 화순의 예비군 무기고를 통해 총기와 탄약을 확보한 시민들은 시민군을 조직했고, 아시아자동차에서 차량을 확보해 외부로 광주의 소식을 알렸다. 계엄군은 시 외곽으로 철수했고, 시민군은 전남도청을 점령했다. 하지만 같은 날 저녁, 보안사는 계엄군에게 자위권 발동을 명령했고, 광주 지역 시위를 '광주사태'로 규정하며 강경 진압 방침을 공식화했다.\\n\\n5월 22일부터 광주는 완전히 고립되었다. 통신과 교통이 차단된 상황 속에서 시민들은 자율적으로 치안을 유지했고, '해방광주'라는 이름으로 불릴 만큼 질서 있는 자치가 이루어졌다. 시민군은 무기를 수거하고 시민 대표를 구성해 계엄군과 협상을 시도했으며, 이 기간 동안 광주에서는 약탈이나 범죄 없이 평화적인 분위기가 유지되었다. 행정 공무원들도 도청에 출근하며 양곡 방출, 부상자 치료 등의 업무를 이어갔다.\\n\\n하지만 5월 27일 새벽, 계엄군은 25,000명의 병력을 투입해 '상무충정작전'을 개시하고 도심에 재진입했다. 오전 2시경부터 전남도청에 무차별 사격을 가했고, 끝까지 남은 시민군과 격렬한 교전 끝에 도청을 점령했다. 일부는 투항을 주장했으나 다수는 끝까지 항전했으며, 이로써 열흘 간의 광주민중항쟁은 군의 무력 진압으로 막을 내렸다.")
                .meaning("광주 민주화 운동은 대한민국 민주주의 발전의 중요한 전환점이 되었으며, 시민과 민중이 민주주의를 향해 나아가고자 했던 의지를 대내외에 분명히 드러낸 사건이었다. 이 운동은 군사독재의 폭력성과 비민주성을 국제사회에 알렸고, 군부 정권의 정당성을 약화시켰다. 또한 1987년 6월 항쟁의 촉매 역할을 하며, 민주화의 흐름을 이어가는 데 결정적 영향을 미쳤다.\\n이 운동은 특정 지역에만 국한된 투쟁으로는 한계가 있으며, 전국적인 연대와 저항이 병행될 때 의미 있는 성과를 얻을 수 있다는 교훈도 남겼다.\\n또한 광주의 민주화 운동은 아시아 여러 나라의 민주화 운동에도 영감을 주었다. 유네스코는 이 사건이 1980년대 한국뿐 아니라 필리핀, 태국, 중국, 베트남 등지의 민주화운동에도 영향을 끼쳤다고 평가했다.")
                .shortInfoEng("It was a civilian uprising that took place in Gwangju on May 18, 1980, in which citizens rejected the military junta and demanded democratization.")
                .backgroundEng("The Fall of the Yushin Regime and the Rise of the Military Junta\\nOn October 26, 1979, President Park Chung-hee was assassinated by Kim Jae-gyu, the director of the Korean Central Intelligence Agency, in what became known as the   'October 26 Incident.' This marked the end of the Yushin regime. Amid growing calls for constitutional reform and a return to democratic governance, President Choi Kyu-hah lifted the emergency decrees on November 7, allowing discussions on constitutional amendments that had previously been banned.\\nHowever, on December 12, 1979, Chun Doo-hwan, then chief of the Defense Security Command, arrested Army Chief of Staff General Jeong Seung-hwa under the pretext of a coup investigation and launched a military coup. This crushed public hopes for a transition to a democratic government. In February 1980, Chun instructed the Defense Security Command to initiate   'Operation K' to suppress pro-democracy sentiment and justify military involvement in politics.\\n\\nThe Seizure of Power and Suppression of Democracy\\nIn early May 1980, under the direction of Chun Doo-hwan—who had also become the acting director of the KCIA—the military plotted to seize control by disabling the National Assembly and the Cabinet. The plan, known as the   'National Stabilization Plan,' included the nationwide expansion of martial law, the dissolution of the National Assembly, and the establishment of the National Security Emergency Committee. The aim was to suppress public resistance and ensure a smooth power takeover by the military.\\n\\nOn May 10, the KCIA issued a report based on intelligence from Japan's Cabinet Research Office, warning of unusual military activity in North Korea—a theory dubbed the   'North Korean invasion rumor.' However, on May 11, the Army Intelligence Division concluded that such rumors were baseless. On May 13, U.S. Forces Korea Commander General John Wickham also reported to Washington that the invasion rumors had no merit and believed they were a pretext fabricated by Chun to seize the presidency. On the same day, the U.S. State Department announced it had received no intelligence supporting the North Korean threat. Later, the Japanese official who had allegedly provided the intel denied ever giving such specific information, revealing that the military junta had fabricated the   'invasion threat' to justify its actions.\\n\\nPublic Uprising and Escalation\\nMeanwhile, as the public pushed for a faster democratic transition, the government and the National Assembly began accelerating constitutional reform plans. On May 12, both ruling and opposition party leaders submitted constitutional amendment proposals, and an extraordinary session of the National Assembly was scheduled for May 20 to discuss key political issues, including lifting martial law. On the same day, Prime Minister Shin Hyun-hwak announced the government's intent to expedite the constitutional revision process.\\n\\nAmidst this political tension, massive demonstrations broke out. In early May, over 100,000 students and citizens gathered at Seoul Station to protest against the military's political interference. On May 15, a young protester commandeered a bus and broke through police lines, fatally injuring a riot police officer and seriously wounding four others. Using this incident as justification, the junta expanded martial law nationwide at midnight on May 17. At 2:00 a.m. on May 18, troops sealed off the National Assembly, effectively suspending the constitutional government. Twenty-six politicians, including Kim Dae-jung and Kim Jong-pil, were taken to the Joint Investigation Headquarters, and over 2,600 students, professors, and dissidents were arrested. New Democratic Party leader Kim Young-sam was placed under house arrest by armed military police.\\n\\nIn protest against these anti-democratic actions—such as the nationwide martial law, ban on political activities, and forced school closures—students at Chonnam National University held a rally in front of the main gate on the morning of May 18. The paratroopers responded with brutal force, beating and assaulting the students. This excessive military violence became the immediate catalyst for the Gwangju Uprising, also known as the May 18 Democratic Movement.")
                .progressEng("Events Leading up to the Uprising – Pre-May 17 Protests\\n\\nOn May 15, 1980, more than 30,000 students gathered in front of the provincial government building (Jeonnam Provincial Office) in Gwangju. A returning student leader, Jeong Dong-nyeon, publicly read a declaration regarding the national situation, followed by a large-scale street march. Student leaders instructed others to gather in front of their universities at 10 a.m. the next day, and then reconvene at noon at the provincial office square if martial law was enforced.\\nAt 9 p.m. on May 17, under pressure from the new military regime, an emergency cabinet meeting was held and decided to expand martial law nationwide. At around 10 p.m., key opposition leaders, including Kim Dae-jung, Kim Young-sam, and Kim Jong-pil, were arrested. Military forces occupied the National Assembly, paralyzing its functions.\\nAt midnight, Martial Law Decree No. 10 was issued, which shut down universities, banned political activities, and intensified press censorship. By 2 a.m. on May 18, airborne troops (paratroopers) from the 7th Airborne Brigade had occupied Chonnam National University and Chosun University, setting up checkpoints at school entrances throughout Gwangju.\\n\\n⸻\\n\\nStudent Demonstrations and Military Violence\\n\\nNews of the nationwide martial law expansion was broadcast via television, radio, and newspapers on the morning of May 18. That same morning, about 100 students from Chonnam National University clashed with paratroopers stationed at the school gate, throwing stones. Injuries to soldiers triggered a brutal response: students were beaten severely, and some moved to the downtown area (Geumnam-ro).\\nAround 300 students later regrouped at the Catholic Center and continued protesting, prompting the police to respond with tear gas.\\n\\n⸻\\n\\nBrutal Crackdown by the Military\\n\\nTo suppress the protests quickly and forcefully, the military deployed the 7th Airborne Brigade into the city at 4 p.m. on May 18. These troops assaulted not only protesters but also ordinary pedestrians indiscriminately. Enraged students and citizens gathered in downtown Gwangju, where they were again met with lethal force—batons, bayonets, and firearms were used against them without distinction.\\n\\n⸻\\n\\nTransformation of the Protest into a Civil Uprising\\n\\nFrom May 19, the protests grew as ordinary citizens, including high school students, joined in anger over the military's brutality. By the afternoon, at least 3,000 citizens had joined. The suppression became more violent, and by May 20, the protest swelled to over 200,000 participants.\\nTaxis and buses were used to block military access points. Soldiers beat civilians with rifle butts and clubs, stabbed them with bayonets, and stripped them in public. Citizens even attempted to appeal directly to the military command, but were ignored.\\nFurious at the media's portrayal of protesters as   'rioters and rebels,' demonstrators set fire to the Gwangju MBC broadcasting station. That night, the military opened fire on civilians in front of Gwangju Station—the first mass shooting incident. Despite orders from higher command to withhold live ammunition, units such as the 11th Airborne Brigade distributed live rounds and escalated the violence the next day.\\n\\n⸻\\n\\nMassacre on May 21\\n\\nOn the morning of May 21, citizens and students faced off with the military in front of the Jeonnam Provincial Office and Chonnam National University. Negotiations between citizen representatives and military forces broke down.\\nAlthough a provincial governor announced that troops would withdraw by noon, the paratroopers remained. At around noon and again at 1 p.m., troops opened fire on protesters. Paratroopers then took sniper positions on rooftops along Geumnam-ro, shooting into crowds and causing heavy casualties.\\nOverwhelmed hospitals across the city struggled to treat the flood of injured civilians.\\n\\n⸻\\n\\nArmed Civil Resistance\\n\\nFrom the afternoon of May 21, citizens began arming themselves in self-defense. Weapons were taken from reserve armories in Naju and Hwasun. Vehicles were seized from the Asia Motors plant to spread the news of the uprising to nearby areas.\\nThe martial law forces retreated to the outskirts of Gwangju, and citizens took control of the Jeonnam Provincial Office. That evening, Brigadier General Jeong Do-young of the Defense Security Command issued a   'self-defense rights' warning on behalf of Chun Doo-hwan, labeling the Gwangju Uprising as a   'rebellion by impure elements and mobs.'\\n\\n⸻\\n\\nSiege of Gwangju\\n\\nAt 7:30 p.m. on May 21, the military initiated Operation Order 80-5 to blockade Gwangju completely. At 9:30 p.m., the order to allow defensive fire was officially announced, and live ammunition began to be distributed again.\\nNumerous atrocities occurred during this period, including shootings of minibuses in Joo-nam Village and massacres in Songam-dong. Miscommunication between military units led to friendly fire on May 24, resulting in the deaths of 13 soldiers.\\n\\n⸻\\n\\nCivil Self-Governance\\n\\nFrom May 22 onward, Gwangju was isolated from the outside world. With communication and transportation cut off, citizens organized their own defense and governance.\\nThe Citizen Militia maintained order, negotiated with the military, collected weapons, and continued to demand democratization and the release of political prisoners. Remarkably, there were no major incidents, looting, or crimes during this self-rule period.\\nGovernment officials, including the deputy governor of South Jeolla Province, continued to work from the provincial office, ensuring that administrative duties like food distribution and medical support continued.\\nThis period is referred to as   'Liberated Gwangju' or the   'Gwangju Commune,' and some intellectuals have likened it to the Paris Commune of 1871.\\n\\n⸻\\n\\nThe Final Military Assault\\n\\nIn the early morning hours of May 27, the military launched Operation Chungjeong, mobilizing 25,000 troops to retake the city.\\nBy 2 a.m., troops had entered Gwangju, and by morning, they stormed the provincial office, firing more than 10,000 rounds and killing many of the remaining civilian fighters.\\nSome advocated for surrender, others for a final stand. In the end, the military overran the building, arresting survivors and bringing the uprising to a violent conclusion\\n")
                .meaningEng("The Gwangju Democratization Movement served as a pivotal turning point in South Korea's journey toward democracy. It powerfully demonstrated the will of citizens and the people to resist authoritarianism and pursue democratic ideals. By exposing the brutality and anti-democratic nature of military dictatorship to the international community, the movement significantly undermined the legitimacy of the regime. Furthermore, it played a catalytic role in the June Democratic Uprising of 1987, further advancing the country's democratic reforms.\\nThe movement also imparted a hard-earned lesson: that democratic struggles confined to a single region have their limits, and meaningful outcomes require nationwide solidarity and resistance.\\nBeyond Korea, the Gwangju Uprising has been recognized for inspiring democracy movements across Asia. UNESCO acknowledged its influence not only in K'orea during the 1980s but also in democratization movements in countries such as the Philippines, Thailand, China, and Vietnam.")
                .date(LocalDateTime.of(1980, 5, 18, 0, 0))
                .nation("대한민국")
                .nameEng("Gwangju Uprising")
                .nationEng("Republic of Korea")
                .eventImage("https://example.com/images/gwangju.jpg")
                .eventStampImage("https://example.com/images/stamp1.jpg")
                .build());

        Event event2 = eventRepository.save(Event.builder()
                .name("광주학생항일운동")
                .shortInfo("1929년 학생들이 주도한 항일 운동")
                .background("긴 설명 생략 또는 요약...")
                .progress("긴 설명 생략 또는 요약...")
                .meaning("긴 설명 생략 또는 요약...")
                .date(LocalDateTime.of(1929, 11, 3, 0, 0))
                .nation("대한민국")
                .nameEng("Gwangju Student Independence Movement")
                .nationEng("Republic of Korea")
                .eventImage("https://example.com/images/independence.jpg")
                .eventStampImage("https://example.com/images/stamp2.jpg")
                .build());

        Location loc1 = locationRepository.save(Location.builder()
                .name("전일빌딩 245")
                .event(event1)
                .address("광주광역시 동구 금남로 245")
                .image("https://example.com/images/geumnamro.jpg")
                .simpleImage("https://example.com/images/geumnamro.jpg")
                .shortInfo("전일빌딩은 옛 전남도청 바로 앞에 위치한 건물로, 1980년 5·18 민주화운동 당시 계엄군의 헬기 기총소사 흔적이 발견된 장소.")
                .shortInfoEng("SThe Jeonil Building, located directly in front of the former South Jeolla Provincial Office, is the site where evidence of helicopter machine gun fire by martial law forces during the May 18 Gwangju Democratization Movement in 1980 was discovered.")
                .historicInfo("1980년 5월 21일 집단 발포 이전, 계엄군은 전일빌딩과 광주관광호텔을 중심으로 저지선을 구축했다. 집단 발포 당시 전일빌딩 옥상에 배치된 군이 조준사격을 가했으며, 5월 27일 새벽 시민군은 전일빌딩과 구 전남도청, 광주YWCA 등에서 최후 항전을 벌였다. 당시 가장 높은 건물이었던 전일빌딩은 계엄군이 먼저 점령했고, 이후 인근 시민군과 교전이 이어졌다. 한편, 헬기 사격에 대한 목격과 증언은 사건 직후부터 제기되었으며, 특히 조비오 신부를 비롯해 여러 시민들이 헬기에서의 기총소사 장면을 목격했다고 진술했다. 하지만 오랫동안 헬기 사격의 실체는 부정되거나 입증되지 못한 채 남아 있었다. 그러던 중 2017년, 전일빌딩 10층에서 200개 이상의 탄흔이 발견되었고, 조사 결과 이는 더 높은 곳에서 발사된 것으로 확인되었다. 이를 통해 헬기 사격이 사실로 밝혀졌고, 신군부의 '자위권' 주장은 설득력을 상실하게 되었다.")
                .historicInfoEng("Prior to the mass shooting on May 21, 1980, martial law forces had established a defense line centered around the Jeonil Building and the Gwangju Tourist Hotel. During the shooting, troops stationed on the rooftop of the Jeonil Building engaged in targeted sniper fire. On the final day of the Gwangju Uprising, May 27, citizen militias staged their last stand at the former Jeonnam Provincial Office, the Jeonil Building, and the nearby Gwangju YWCA. The Jeonil Building, being the tallest structure in the area, was seized first by the military, followed by battles with armed citizens in nearby locations. A major breakthrough came in 2017—37 years after the uprising—when over 200 bullet marks were discovered on the 10th floor of the Jeonil Building. Analysis revealed that the bullets had come from a point higher than the 10th floor, leading to the conclusion that the shots were fired from a helicopter. This discovery confirmed the reality of helicopter gunfire and undermined the military regime's justification of the crackdown as   'self-defense.'")
                .etiquette("1. 전일빌딩245는 5·18 민주화운동의 상징적인 장소입니다. 경건한 마음으로 조용히 관람해 주세요.\\n2. 전시물이나 벽면, 탄흔 보존구역 등에 손대지 마세요. 역사 유산의 훼손은 공동의 기억을 해치는 일입니다.\\n3. 사진 촬영은 가능하지만, 플래시 사용은 삼가고 추모 공간에서는 신중하게 행동해 주세요.\\n4. 실내에서는 음식물 섭취를 삼가 주세요. 깨끗한 관람 환경 유지를 위해 협조 부탁드립니다.\\n5. 전시물 관람이나 해설, 영상 시청 시 다른 관람객을 방해하지 않도록 조용히 참여해 주세요.\\n6. SNS 등에 관람 후기를 공유할 때는 5·18 정신을 존중하는 표현을 사용해 주세요.")
                .etiquetteEng("1. Jeonil Building 245 is a symbolic site of the May 18 Democratization Movement. Please observe with a quiet and respectful attitude.\\n2. Do not touch exhibits, walls, or preserved bullet marks. Damaging historical remains harms our shared memory.\\n3. Photography is allowed, but refrain from using flash and be mindful in memorial spaces.\\n4. Please refrain from eating or drinking inside the exhibition area to help maintain a clean environment.\\n5. When viewing exhibits, listening to guides, or watching videos, keep quiet so as not to disturb others.\\n6. If you share your visit on social media, please use language that respects the spirit of May 18.")
                .openTime("09:00")
                .closeTime("22:00")
                .phoneNum("062-225-0245")
                .exhibitionTime("11:00, 13:00, 14:30, 16:00, 17:30")
                .available("Stroller, Wheelchair")
                .translate("한국어 / 영어 / 중국어")
                .nameEng("Jeonil Building 245")
                .addressEng("245, Geumnam-ro, Dong-gu, Gwangju-si, South Korea")
                .build());

        Location loc2 = Location.builder()
                .name("전남대학교 정문")
                .event(event1)
                .address("광주광역시 북구 용봉로 77 전남대학교")
                .image("https://example.com/images/chonnam_gate.jpg")
                .simpleImage("https://example.com/images/geumnamro.jpg")
                .shortInfo("전남대학교 정문은 개교 이래 학생들이 더 나은 세상을 꿈꾸며 민주화를 외쳤던 상징적인 장소이자, 5·18 민중항쟁이 시작된 역사적인 현장이다.")
                .shortInfoEng("The main gate of Chonnam National University is a symbolic site where students have long voiced their hopes for a better world and democracy—and most notably, it is where the May 18 Gwangju Uprising began.")
                .historicInfo("전남대학교 정문은 한국 민주주의 역사에서 찬란히 빛나는 5·18 광주민중항쟁이 시작된 상징적인 장소이다. 1980년 5월 17일 자정, 불법적인 비상계엄 전국 확대 조치로 계엄군이 전남대에 진입하였고, 도서관에서 공부하던 학생들을 무차별 구타하고 불법적으로 연행하면서 항쟁의 불씨가 지펴졌다. 다음 날인 5월 18일 오전 10시, 학생들은 박관현 총학생회장과의 약속을 기억하며 정문 앞에 모였고, 학교 출입을 막는 계엄군과의 충돌을 시작으로 광주역과 금남로로 진출해 시민들과 함께 시위를 벌이며 본격적인 민중항쟁이 시작되었다. 이후 이곳은 민주주의, 인권, 평화를 상징하는 공간으로 자리매김하였다.")
                .historicInfoEng("On May 17, 1980, when martial law was extended nationwide and the military took control of Chonnam National University, students gathered at the university's main gate at 10 a.m. the next day, remembering their promise to Student Council President Park Kwan-hyun. They clashed with soldiers blocking access to the campus and then moved toward Geumnam-ro, joining citizens in protest—marking the beginning of the May 18 People's Uprising. Since then, the university's main gate has become a symbolic space where students yearning for democracy confronted state power, and it now stands as a monument to democracy, human rights, and peace.")
                .etiquette("1. 전남대 정문은 5·18 민주화운동의 발화점입니다. 단순한 출입구가 아닌 기억의 공간임을 기억하고, 경건한 마음으로 방문해 주세요.\n2. 집회나 행사가 있을 경우 타인과의 충돌 없이 평화롭게 참여하고, 학교 구성원의 학습·업무를 방해하지 않도록 배려해 주세요.\n3. 전단지 무단 배포, 쓰레기 투기 등을 삼가고 대학 캠퍼스를 존중하는 태도를 보여 주세요.\n4. 개인 SNS 게시용 촬영은 가능하나, 희생자 추모나 집회 장면을 포함할 경우 신중하게 접근하고 타인의 초상권을 침해하지 않도록 주의해 주세요.\n5. 캠퍼스는 학생과 교직원의 공간이기도 하므로 수업, 시험, 연구 활동을 방해하지 않도록 조용히 이동해 주세요.")
                .etiquetteEng("1. Recognize the historical significance: The main gate is not just an entrance but a symbolic starting point of the May 18 Democratization Movement. Please visit with respect and awareness.\n2. Maintain order during gatherings or protests: Participate peacefully and avoid disrupting students or university staff.\n3. Keep the environment clean: Do not litter or distribute flyers indiscriminately. Show respect for the university campus.\n4. Be mindful when taking photos or videos: While personal photos are allowed, be cautious when photographing memorials or gatherings, and respect others' privacy and portrait rights.\n5. Respect students and faculty: The campus is a space for education and research. Avoid loud behavior and unnecessary interference.")
                .openTime("00:00")
                .closeTime("24:00")
                .phoneNum("062-530-5114")
                .exhibitionTime("24HR")
                .available("Not Supported")
                .translate("Not supported")
                .nameEng("Chonnam National University Main Gate")
                .addressEng("77, Yongbong-ro, Buk-gu, Gwangju, Republic of Korea")
                .build();
        locationRepository.save(loc2);


        User user = userRepository.save(User.builder()
                .email("user@example.com")
                .uid("firebase-uid-001")
                .build());

        keywordRepository.saveAll(List.of(
                Keyword.builder().keyword("#민주주의").keywordEng("#Democracy").event(event1).korEngFlag(1).build(),
                Keyword.builder().keyword("#광주").keywordEng("#Gwangju").event(event1).korEngFlag(1).build(),
                Keyword.builder().keyword("#대한민국").keywordEng("#Korea").event(event1).korEngFlag(1).build(),
                Keyword.builder().keyword("#시민 저항").keywordEng("#Civil Resistance").event(event1).korEngFlag(1).build(),
                Keyword.builder().keyword("#신군부").keywordEng("#Junta").event(event1).korEngFlag(1).build()
        ));

        // 전남대 정문 관련 키워드
        keywordRepository.saveAll(List.of(
                Keyword.builder().keyword("#학생운동").keywordEng("#Student Movement").location(loc2).korEngFlag(1).build(),
                Keyword.builder().keyword("#대한민국").keywordEng("#Korea").location(loc2).korEngFlag(1).build(),
                Keyword.builder().keyword("#민주주의").keywordEng("#Democracy").location(loc2).korEngFlag(1).build(),
                Keyword.builder().keyword("#1980년대").keywordEng("#1980s").location(loc2).korEngFlag(1).build()
        ));

        // 전일빌딩 관련 키워드
        keywordRepository.saveAll(List.of(
                Keyword.builder().keyword("#추모공간").keywordEng("#Memorial Space").location(loc1).korEngFlag(1).build(),
                Keyword.builder().keyword("#민주주의").keywordEng("#Democracy").location(loc1).korEngFlag(1).build(),
                Keyword.builder().keyword("#국가폭력").keywordEng("#State Violence").location(loc1).korEngFlag(1).build(),
                Keyword.builder().keyword("#시민항전").keywordEng("#Civil Resistance").location(loc1).korEngFlag(1).build(),
                Keyword.builder().keyword("#1980년대").keywordEng("#1980s").location(loc1).korEngFlag(1).build()
        ));

        Letter letter = letterRepository.save(Letter.builder()
                .location(loc1)
                .user(user)
                .stampImg("https://example.com/stamp.jpg")
                .markImg("https://example.com/mark.jpg")
                .content("AI가 작성한 편지입니다.")
                .letterTime(LocalDateTime.now())
                .build());

        Stamp stamp = stampRepository.save(Stamp.builder()
                .event(event1)
                .owner(user)
                .location(loc1)
                .statusTime(LocalDateTime.now())
                .stampImage("image.jpg")
                .build());

        Visited visited = visitedRepository.save(Visited.builder()
                .user(user)
                .location(loc1)
                .comment("광주의 진실을 기억합니다.")
                .likes(5)
                .createdAt(LocalDateTime.now())
                .deleted(false)
                .edited(false)
                .imageUrl("https://example.com/images/comment1.jpg")
                .build());

        Chat chat = Chat.builder()
                .user(user)
                .location(loc1)
                .chatTarget("AI")
                .chatQuestion("1980년 5월 광주에서 무슨 일이 있었나요?")
                .chatAnswer("1980년 5월, 광주에서는 민주화를 요구하는 시민과 학생들이 신군부에 의해 무자비하게 진압당한 광주 민주화운동이 발생했습니다.")
                .build();

        chatRepository.save(chat);

        commentReportRepository.saveAll(List.of(
                CommentReport.builder().comment(visited).reporter(user).reason("부적절한 표현이 포함되어 있습니다.").reportedAt(LocalDateTime.now()).build()
        ));
    }
}