package com.nikitayankov.resumebuilder.core.models.cv;

import com.nikitayankov.resumebuilder.core.models.cv.achievement.Achievement;
import com.nikitayankov.resumebuilder.core.models.cv.skill.Skill;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class CV extends RealmObject implements Serializable {
    private String mName;
    private String mVacancy;
    private long mSalary;

    private String mEmail;
    private String mPhone;

    private RealmList<Skill> mSkills = new RealmList<Skill>();
    private RealmList<Achievement> mAchievements = new RealmList<Achievement>();

    public static Builder newBuilder() {
        return new CV().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder setName(String name) {
            CV.this.mName = name;

            return this;
        }

        public Builder addContactInformation(CVContactInformation contactInformation) {
            CV.this.mEmail = contactInformation.getEmail();
            CV.this.mPhone = contactInformation.getPhone();

            return this;
        }

        public Builder setVacancy(String vacancy) {
            CV.this.mVacancy = vacancy;

            return this;
        }

        public Builder setSalary(long salary) {
            CV.this.mSalary = salary;

            return this;
        }

        public Builder addSkill(Skill skill) {
            CV.this.mSkills.add(skill);

            return  this;
        }

        public Builder addSkills(List<Skill> skills) {
            CV.this.mSkills.addAll(skills);

            return this;
        }

        public Builder addAchievement(Achievement achievement) {
            CV.this.mAchievements.add(achievement);

            return this;
        }

        public Builder addAchievements(List<Achievement> achievements) {
            CV.this.mAchievements.addAll(achievements);

            return this;
        }

        public CV build() {
            return CV.this;
        }
    }

    public String getName() {
        return mName;
    }

    public String getVacancy() {
        return mVacancy;
    }

    public long getSalary() {
        return mSalary;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getPhone() {
        return mPhone;
    }

    public RealmList<Skill> getSkills() {
        return mSkills;
    }

    public RealmList<Achievement> getAchievements() {
        return mAchievements;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public JSONObject toJSON() {
        return new JSONObject();
    }
}
