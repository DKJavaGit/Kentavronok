package com.example.kentavr;
import javafx.scene.control.Alert;

import java.util.Arrays;
import java.util.List;

public class PasswordGen {
    // Заполнение списков словами разных языков
    final List<String> EnglishWords = Arrays.asList(
            "Actor", "Gold", "Painting", "Advertisement", "Grass", "Parrot",
            "Afternoon", "Greece", "Pencil", "Airport", "Guitar", "Piano",
            "Ambulance", "Hair", "Pillow", "Animal", "Hamburger", "Pizza",
            "Answer", "Helicopter", "Planet", "Apple", "Helmet", "Plastic",
            "Army", "Holiday", "Portugal", "Australia", "Honey", "Potato",
            "Eggplant", "Market", "Umbrella", "Egypt", "Match", "Van",
            "Elephant", "Microphone", "Vase", "Energy", "Monkey", "Vegetable",
            "Engine", "Morning", "Vulture", "England", "Motorcycle", "Wall",
            "Evening", "Nail", "Whale", "Eye", "Napkin", "Window",
            "Family", "Needle", "Wire", "Finland", "Nest", "Xylophone",
            "Fish", "Nigeria", "Yacht", "Flag", "Night", "Yak",
            "Flower", "Notebook", "Zebra", "Football", "Ocean", "Zoo",
            "Forest", "Oil", "Garden", "Fountain", "Orange", "Gas"
    );
    final List<String> RussianWords = Arrays.asList(
            "Актер", "Золото", "Живопись", "Реклама", "Трава", "Попугай",
            "Полдень", "Греция", "Карандаш", "Аэропорт", "Гитара", "Фортепиано",
            "Скорая", "Помощь", "Подушка", "Волосы", "Животное", "Гамбургер", "Пицца",
            "Ответ", "Вертолет", "Планета", "Яблоко", "Шлем", "Пластик",
            "Армейский", "Праздничный", "Португалия", "Австралия", "Медовый", "Картофельный",
            "Баклажан", "Базар", "Зонтик", "Египет", "Спичка", "Фургон",
            "Слон", "Микрофон", "Ваза", "Энергия", "Обезьяна", "Овощ",
            "Паровоз", "Утро", "Стервятник", "Англия", "Мотоцикл", "Стена",
            "Вечер", "Гвоздь", "Кит", "Глаз", "Салфетка", "Окно",
            "Семья", "Игла", "Проволока", "Финляндия", "Гнездо", "Ксилофон",
            "Рыба", "Нигерия", "Яхта", "Флаг", "Ночь", "Як",
            "Цветок", "Тетрадь", "Зебра", "Футбол", "Океан", "Зоопарк",
            "Лес", "Масло", "Сад", "Фонтан", "Апельсин", "Газ"
    );
    final List<String> ChineseWords = Arrays.asList(
            "演员", "金牌", "绘画", "广告", "草", "鹦鹉",
            "中午", "希腊", "铅笔", "机场", "吉他", "钢琴",
            "救", "护车", "毛枕", "动物", "汉堡包", "披萨",
            "答案", "直升机", "星球", "苹果", "头盔", "塑料",
            "军队", "节日", "葡萄牙", "澳大利亚", "蜂蜜", "土豆",
            "茄子", "芭莎", "雨伞", "埃及", "火柴", "面包车",
            "大象", "麦克风", "花瓶", "能量", "猴子", "蔬菜",
            "火车头", "早晨", "秃鹰", "英国", "摩托车", "墙",
            "晚上", "指甲", "工具包", "眼睛", "餐巾", "窗户",
            "家庭", "针", "线", "芬兰", "鸟巢", "木琴",
            "鱼", "尼日利亚", "游艇", "国旗", "夜", "牦牛",
            "花", "笔记本", "斑马", "足球", "海洋", "动物园",
            "森林", "石油", "花园", "喷泉", "橙子", "天然气"
    );

    final List<String> specialCharacters = Arrays.asList(
            "~", "`", "!", "@", "\"", "№", "#", "$", "%", "^", "&", ";", "*", ",", "(", ")", ".", ":"
    );

    String language;
    String type;
    int length;

    public String getRandomElement(List<String> list) {
        return list.get((int) (Math.random() * list.size()));
    }

    public String getRandomElements(List<String> list, int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++)
            stringBuilder.append(list.get((int) (Math.random() * list.size())));
        return stringBuilder.toString();
    }

    public String getRandomNumbers(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++)
            stringBuilder.append((int) (Math.random() * 9));
        return stringBuilder.toString();
    }

    // Создание общего генератора пароля
    public String create()
    {
        StringBuilder password = new StringBuilder();
        List<String> listOfLanguage;

        switch (language)
        {
            case "Русский":
                listOfLanguage = RussianWords;
                password = new StringBuilder(createPasswordList(listOfLanguage));
                break;
            case "English":
                listOfLanguage = EnglishWords;
                password = new StringBuilder(createPasswordList(listOfLanguage));
                break;
            case "简体中文":
                listOfLanguage = ChineseWords;
                password = new StringBuilder(createPasswordList(listOfLanguage));
                break;
        }
        // Лист определен, можно подставлять
        return password.toString();
    }

    // Создание пароля с помощью list
    public String createPasswordList(List<String> languageList) {
        StringBuilder password = new StringBuilder();

        if (length >= 8 && length <= 20) {
            switch (type) {
                case "Слово + цифры":
                    // Создание пароля с типом "Слово + цифры"
                    String word1 = getRandomElement(languageList);
                    if (length <= word1.length())
                        while (length <= word1.length())
                            word1 = getRandomElement(languageList);
                    String numbers1 = getRandomNumbers((length - word1.length()));
                    password = new StringBuilder(word1 + numbers1);
                    break;
                case "Цифры + слово":
                    // Создание пароля с типом "Цифры + слово"
                    String word2 = getRandomElement(languageList);
                    if (length <= word2.length())
                        while (length <= word2.length())
                            word2 = getRandomElement(languageList);
                    String numbers2 = getRandomNumbers((length - word2.length()));
                    password = new StringBuilder(numbers2 + word2);
                    break;
                case "Символы + цифры":
                    // Создание пароля с типом "Символы + цифры"
                    String characters1 = getRandomElements(specialCharacters, (int) (Math.random() * length));
                    String numbers3 = getRandomNumbers(length - characters1.length());
                    password = new StringBuilder(characters1 + numbers3);
                    break;
                case "Только цифры":
                    // Создание пароля с типом "Только цифры"
                    password = new StringBuilder(getRandomNumbers(length));
                    break;
                case "Только символы":
                    // Создание пароля с типом "Только символы"
                    password = new StringBuilder(getRandomElements(specialCharacters, length));
                    break;
                case "Только слова":
                    // Создание пароля с типом "Только слова"
                    int lengthCopy = length;
                    do {
                        String newWord = getRandomElement(languageList);
                        if (lengthCopy - newWord.length() < 0)
                        {
                            int i = 0;
                            while (lengthCopy - newWord.length() < 0 & i != languageList.size())
                            {
                                newWord = getRandomElement(languageList);
                                i++;
                            }
                            if (i == languageList.size())
                                switch (language)
                                {
                                    case "Русский":
                                        newWord = "И";
                                        break;
                                    case "English":
                                        newWord = "A";
                                        break;
                                    default:
                                        newWord = "字";
                                        break;
                                }
                        }
                        password.append(newWord);
                        lengthCopy -= newWord.length();
                    } while (lengthCopy > 0);
                    break;
                case "Разнобой всего":
                    // Создание пароля с типом "Разнобой всего"
                    StringBuilder word4 = new StringBuilder(getRandomElement(languageList));
                    if (length <= word4.length())
                        while (length <= word4.length())
                            word4 = new StringBuilder(getRandomElement(languageList));
                    StringBuilder numbers4 = new StringBuilder(getRandomNumbers((length - word4.length() - ((int) (Math.random() * 3)))));
                    if ((numbers4.length() + word4.length()) >= length)
                        while (length <= (numbers4.length() + word4.length()))
                            numbers4 = new StringBuilder(getRandomNumbers((length - word4.length() - ((int) (Math.random() * 3)))));
                    StringBuilder characters = new StringBuilder(getRandomElements(specialCharacters, (length - word4.length() - numbers4.length())));

                    int random = (int) (Math.random() * 3);
                    switch (random)
                    {
                        case 0:
                            password.append(characters.append(numbers4).append(word4));
                            break;
                        case 1:
                            password.append(word4.append(numbers4).append(characters));
                            break;
                        case 2:
                            password.append(numbers4.append(word4).append(characters));
                            break;
                        case 3:
                            password.append(characters.append(word4).append(numbers4));
                            break;
                    }
            }
        }
        else
        {
            // Создание уведомления об мал/бол размере
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Внимание!");
            if (length < 8)
                alert.setHeaderText("Размер вашего пароля слишком мал!");
            if (length > 20)
                alert.setHeaderText("Размер вашего пароля слишком большой!");
            alert.setContentText("Число должно быть в диапазоне от 8 до 20");
            alert.showAndWait();
        }

        return password.toString();
    }
    public PasswordGen(String type, int length, String language) {
        this.type = type;
        this.length = length;
        this.language = language;
    }
}