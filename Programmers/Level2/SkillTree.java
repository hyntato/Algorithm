class SkillTree {
    
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
      
        for (String skill_: skill_trees) {
            skill_ = skill_.replaceAll("[^" + skill + "]", "");
            if (skill.indexOf(skill_) == 0) {
                count++;
            }
        }
        return count;
    }
}
